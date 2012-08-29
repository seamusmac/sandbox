package com.ie.sm.client.ui.address;

import com.github.gwtbootstrap.client.ui.SubmitButton;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.ie.sm.shared.AddressDTO;

public class ViewAddressView extends ViewImpl implements
		ViewAddressPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, ViewAddressView> {
	}

	
	@UiField
	AddressEditor address;
	
	@UiField
	SubmitButton validateButton;
	
	@Inject
	public ViewAddressView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	public AddressDTO getAddressDTO() {
		return address.getAddressDTO();
	}
	
	public SubmitButton getValidateButton() {
		return validateButton;
	}
}
