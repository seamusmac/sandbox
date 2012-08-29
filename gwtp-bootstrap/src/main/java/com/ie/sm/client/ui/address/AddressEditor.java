package com.ie.sm.client.ui.address;

import java.util.Arrays;

import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.i18n.client.DefaultLocalizedNames;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.ie.sm.client.decorators.BootstrapDecorator;
import com.ie.sm.client.decorators.BootstrapValueListDecorator;
import com.ie.sm.shared.AddressDTO;

public class AddressEditor extends Composite implements Editor<AddressDTO> {

	private static AddressEditorUiBinder uiBinder = GWT.create(AddressEditorUiBinder.class);
	
	interface AddressEditorUiBinder extends UiBinder<Widget, AddressEditor> {
	}
	
	@UiField
	BootstrapDecorator<String> addressLine1;
	@UiField
	BootstrapDecorator<String> addressLine2;
	@UiField
	BootstrapDecorator<String> addressLine3;
	@UiField
	BootstrapDecorator<String> addressLine4;
	
	@UiField(provided = true)
	@Ignore
	ValueListBox<String> countryList;
	
	@UiField
	BootstrapValueListDecorator<String> country;

	public AddressEditor() {
		countryList = new ValueListBox<String>(new CountryRenderer());
		DefaultLocalizedNames loc = new DefaultLocalizedNames();
		countryList.setAcceptableValues(Arrays.asList(loc.getSortedRegionCodes()));
		initWidget(uiBinder.createAndBindUi(this));
		
	}
}
