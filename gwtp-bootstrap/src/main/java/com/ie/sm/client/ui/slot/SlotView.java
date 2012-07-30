package com.ie.sm.client.ui.slot;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class SlotView extends ViewImpl implements
		SlotPresenter.MyView {

	private final Widget widget;

	@UiField
	FlowPanel container;

	public interface Binder extends UiBinder<Widget, SlotView> {
	}

	@Inject
	public SlotView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == SlotPresenter.TYPE_RevealTopBarContent) {
			setWidgetContent(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

	private void setWidgetContent(Widget content) {
		container.clear();
		if (content != null) {
			container.add(content);
		}

	}
}
