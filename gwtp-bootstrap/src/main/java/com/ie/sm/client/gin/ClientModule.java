package com.ie.sm.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.ie.sm.client.place.ClientPlaceManager;
import com.ie.sm.client.place.DefaultPlace;
import com.ie.sm.client.place.ErrorPlace;
import com.ie.sm.client.place.NameTokens;
import com.ie.sm.client.ui.address.ViewAddressPresenter;
import com.ie.sm.client.ui.address.ViewAddressView;
import com.ie.sm.client.ui.errorpage.ErrorPresenter;
import com.ie.sm.client.ui.errorpage.ErrorView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(ErrorPresenter.class, ErrorPresenter.MyView.class, ErrorView.class, ErrorPresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.address);
		
		bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.error);
		
		bindPresenter(ViewAddressPresenter.class,
				ViewAddressPresenter.MyView.class, ViewAddressView.class,
				ViewAddressPresenter.MyProxy.class);
	}
}
