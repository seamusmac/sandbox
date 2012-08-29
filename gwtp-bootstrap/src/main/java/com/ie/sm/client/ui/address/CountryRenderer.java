package com.ie.sm.client.ui.address;

import com.google.gwt.i18n.client.DefaultLocalizedNames;
import com.google.gwt.text.shared.AbstractRenderer;

public class CountryRenderer extends AbstractRenderer<String> {

	DefaultLocalizedNames loc = new DefaultLocalizedNames();
	private String emptyValue = "";

	@Override
	public String render(String object) {
		if (object == null)
			return emptyValue;
		return loc.getRegionName(object);
	}

	public void setEmptyValue(String emptyValue) {
		this.emptyValue = emptyValue;
	}

}
