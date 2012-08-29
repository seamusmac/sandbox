package com.ie.sm.client.decorators;


import java.util.List;

import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.HelpInline;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;

/**
 * A simple decorator to display leaf widgets with an error message.
 * <p>
 * <h3>Use in UiBinder Templates</h3>
 * <p>
 * The decorator may have exactly one ValueBoxBase added though an
 * <code>&lt;e:valuebox></code> child tag.
 * <p>
 * For example:
 * <pre>
 * &#64;UiField
 * ValueBoxEditorDecorator&lt;String&gt; name;
 * </pre>
 * <pre>
 * &lt;e:ValueBoxEditorDecorator ui:field='name'>
 *   &lt;e:valuebox>
 *     &lt;g:TextBox />
 *   &lt;/e:valuebox>
 * &lt;/e:ValueBoxEditorDecorator>
 * </pre>
 * 
 * @param <Boolean> the type of data being edited
 */
public class BootstrapCheckBoxDecorator extends Composite implements
    HasEditorErrors<Boolean>, IsEditor<LeafValueEditor<Boolean>> {
  interface Binder extends UiBinder<Widget, BootstrapCheckBoxDecorator> {
    Binder BINDER = GWT.create(Binder.class);
  }

  @UiField
  SimplePanel contents;

  @UiField
  @Ignore
  HelpInline error;

  private LeafValueEditor<Boolean> editor;

  /**
   * Constructs a ValueBoxEditorDecorator.
   */
  @UiConstructor
  public BootstrapCheckBoxDecorator() {
    initWidget(Binder.BINDER.createAndBindUi(this));
  }

  /**
   * Constructs a ValueBoxEditorDecorator using a {@link ValueBoxBase}
   * widget and a {@link ValueBoxEditor} editor.
   * 
   * @param widget the widget
   * @param editor the editor
   */
  public BootstrapCheckBoxDecorator(ValueBoxBase<Boolean> widget,
      ValueBoxEditor<Boolean> editor) {
    this();
    contents.add(widget);
    this.editor = editor;
  }

  /**
   * Returns the associated {@link ValueBoxEditor}.
   * 
   * @return a {@link ValueBoxEditor} instance
   * @see #setEditor(ValueBoxEditor)
   */
  public LeafValueEditor<Boolean> asEditor() {
    return editor;
  }

  /**
   * Sets the associated {@link ValueBoxEditor}.
   * 
   * @param editor a {@link ValueBoxEditor} instance
   * @see #asEditor()
   */
  public void setEditor(LeafValueEditor<Boolean> editor) {
    this.editor = editor;
  }

  /**
   * Set the widget that the EditorPanel will display. This method will
   * automatically call {@link #setEditor}.
   * 
   * @param widget a {@link ValueBoxBase} widget
   */
  @UiChild(limit = 1, tagname = "valuebox")
  public void setValueBox(CheckBox widget) {
    contents.add(widget);
    setEditor(widget.asEditor());
  }

  /**
   * The default implementation will display, but not consume, received errors
   * whose {@link EditorError#getEditor() getEditor()} method returns the Editor
   * passed into {@link #setEditor}.
   * 
   * @param errors a List of {@link EditorError} instances
   */
  public void showErrors(List<EditorError> errors) {
    StringBuilder sb = new StringBuilder();
    for (EditorError error : errors) {
      if (error.getEditor().equals(editor)) {
        sb.append("\n").append(error.getMessage());
      }
    }
    
    ControlGroup cg = (ControlGroup)contents.getParent().getParent().getParent().getParent();
    if (sb.length() == 0) {
    	cg.setType(ControlGroupType.NONE);
      error.setText("");
      //errorLabel.getStyle().setDisplay(Display.NONE);
      return;
    }

    error.setText(sb.substring(1));
    cg.setType(ControlGroupType.ERROR);
    //errorLabel.getStyle().setDisplay(Display.INLINE_BLOCK);
  }
}


