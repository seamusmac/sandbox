package com.ie.sm.client.ui.address;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
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
	
	interface Driver extends SimpleBeanEditorDriver<AddressDTO, AddressEditor> {
	}
	private Driver driver;
	
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
		setupDrivers();
	}
	
	private void setupDrivers() {
		driver = GWT.create(Driver.class);
		driver.initialize(this);
		driver.edit(new AddressDTO());
	}
	
	private boolean validationSuccessful() {
		ValidatorFactory factory = Validation.byDefaultProvider().configure().buildValidatorFactory();
		Set<ConstraintViolation<AddressDTO>> violations = factory.getValidator().validate(driver.flush());
		if (violations.size() > 0) {
			driver.setConstraintViolations(new HashSet<ConstraintViolation<?>>(violations));
		}
		if (violations.size() > 0) {
			return false;
		}

		return true;
	}
	
	public AddressDTO getAddressDTO(){
		if (validationSuccessful()) {
			AddressDTO person = driver.flush();
			return person;
		}
		return null;
	}
	
	
}
