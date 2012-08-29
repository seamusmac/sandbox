package com.ie.sm.client.decorators;

import java.util.List;

import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.HelpInline;
import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;

public class BootstrapValueListDecorator<T> extends Composite implements HasEditorErrors<T>, IsEditor<TakesValueEditor<T>> {
	interface Binder extends UiBinder<Widget, BootstrapValueListDecorator<?>> {
		Binder BINDER = GWT.create(Binder.class);
	}

	@UiField
	SimplePanel contents;

	@UiField
	@Ignore
	HelpInline error;

	private TakesValueEditor<T> editor;

	/**
	 * Constructs a ValueBoxEditorDecorator.
	 */
	@UiConstructor
	public BootstrapValueListDecorator() {
		initWidget(Binder.BINDER.createAndBindUi(this));
	}

	/**
	 * Constructs a ValueBoxEditorDecorator using a {@link ValueBoxBase} widget and a {@link ValueBoxEditor} editor.
	 * 
	 * @param widget
	 *            the widget
	 * @param editor
	 *            the editor
	 */
	public BootstrapValueListDecorator(ValueBoxBase<T> widget, ValueBoxEditor<T> editor) {
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
	public TakesValueEditor<T> asEditor() {
		return editor;
	}

	/**
	 * Sets the associated {@link ValueBoxEditor}.
	 * 
	 * @param editor
	 *            a {@link ValueBoxEditor} instance
	 * @see #asEditor()
	 */
	public void setEditor(TakesValueEditor<T> editor) {
		this.editor = editor;
	}

	/**
	 * Set the widget that the EditorPanel will display. This method will automatically call {@link #setEditor}.
	 * 
	 * @param widget
	 *            a {@link ValueBoxBase} widget
	 */
	@UiChild(limit = 1, tagname = "valuebox")
	public void setValueBox(ValueListBox<T> widget) {
		contents.add(widget);
		setEditor(widget.asEditor());
	}

	/**
	 * The default implementation will display, but not consume, received errors whose {@link EditorError#getEditor() getEditor()} method returns the Editor passed into {@link #setEditor}.
	 * 
	 * @param errors
	 *            a List of {@link EditorError} instances
	 */
	public void showErrors(List<EditorError> errors) {
		StringBuilder sb = new StringBuilder();
		for (EditorError error : errors) {
				sb.append("\n").append(error.getMessage());
		}

		ControlGroup cg = (ControlGroup)contents.getParent().getParent().getParent().getParent();
		if (sb.length() == 0) {
			error.setText("");
			cg.setType(ControlGroupType.NONE);
			// errorLabel.getStyle().setDisplay(Display.NONE);
			return;
		}
		cg.setType(ControlGroupType.ERROR);
		error.setText(sb.substring(1));
		// errorLabel.getStyle().setDisplay(Display.INLINE_BLOCK);
	}
}
