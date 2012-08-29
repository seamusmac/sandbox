package com.ie.sm.client.ui.address;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class ViewAddressView extends ViewImpl implements
		ViewAddressPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, ViewAddressView> {
	}

	
//	@UiField
//	AddressEditor address;
	
	@Inject
	public ViewAddressView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
}
