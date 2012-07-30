package com.ie.sm.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;
import com.ie.sm.client.gin.ClientGinjector;
import com.ie.sm.client.resources.Resources;

public class GWTPBootstrap implements EntryPoint {

	private final ClientGinjector ginjector = GWT.create(ClientGinjector.class);

	@Override
	public void onModuleLoad() {
		// This is required for Gwt-Platform proxy's generator
		DelayedBindRegistry.bind(ginjector);
		
		ginjector.getPlaceManager().revealCurrentPlace();
		
		Resources.INSTANCE.style().ensureInjected(); 
	}

}
