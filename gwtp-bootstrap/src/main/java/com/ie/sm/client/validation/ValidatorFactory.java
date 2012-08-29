package com.ie.sm.client.validation;

import javax.validation.Validator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import com.ie.sm.shared.AddressDTO;

public class ValidatorFactory extends AbstractGwtValidatorFactory {

	/**
	 * Only the classes listed in the {@link GwtValidation} annotation can be validated. In my example: Link.class can be validated
	 */
	@GwtValidation(value = { AddressDTO.class })
	public interface GwtValidator extends Validator {
	}

	@Override
	public AbstractGwtValidator createValidator() {
		return GWT.create(GwtValidator.class);
	}

}
