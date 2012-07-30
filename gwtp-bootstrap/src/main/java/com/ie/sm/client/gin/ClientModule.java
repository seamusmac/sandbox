package com.ie.sm.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.ie.sm.client.place.ClientPlaceManager;
import com.ie.sm.client.place.DefaultPlace;
import com.ie.sm.client.place.ErrorPlace;
import com.ie.sm.client.place.NameTokens;
import com.ie.sm.client.ui.errorpage.ErrorPresenter;
import com.ie.sm.client.ui.errorpage.ErrorView;
import com.ie.sm.client.ui.slot.SlotPresenter;
import com.ie.sm.client.ui.slot.SlotView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(ErrorPresenter.class, ErrorPresenter.MyView.class, ErrorView.class, ErrorPresenter.MyProxy.class);

		bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.error);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.slot);

		bindPresenter(SlotPresenter.class,
				SlotPresenter.MyView.class, SlotView.class,
				SlotPresenter.MyProxy.class);
	}
}
