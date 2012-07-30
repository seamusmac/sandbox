package com.ie.sm.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface Resources extends ClientBundle {
	
	public static final Resources INSTANCE =  GWT.create(Resources.class);
	
	@Source("style.css")
	@CssResource.NotStrict
	Style style();
	
	 public interface Style extends CssResource {
		    String myform();
		    String small();
		    String spacer();
		    String stylized();
		    String validationFailedBorder();
		    String validationFailedBackground();
		  }
}
