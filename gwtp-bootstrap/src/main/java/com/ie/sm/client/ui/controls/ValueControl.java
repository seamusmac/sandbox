package com.ie.sm.client.ui.controls;

import com.github.gwtbootstrap.client.ui.ControlLabel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.ie.sm.client.decorators.BootstrapDecorator;

public class ValueControl extends Composite {

	private static ValueControlUiBinder uiBinder = GWT
			.create(ValueControlUiBinder.class);

	interface ValueControlUiBinder extends UiBinder<Widget, ValueControl> {
	}

	@UiField
	ControlLabel label;
	
	@UiField
	BootstrapDecorator<String> formInputValueBox;
	
	public ValueControl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
