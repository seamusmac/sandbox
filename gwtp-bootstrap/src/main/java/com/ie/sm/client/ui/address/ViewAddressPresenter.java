package com.ie.sm.client.ui.address;

import com.github.gwtbootstrap.client.ui.SubmitButton;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.ie.sm.client.place.NameTokens;
import com.ie.sm.shared.AddressDTO;

public class ViewAddressPresenter extends
		Presenter<ViewAddressPresenter.MyView, ViewAddressPresenter.MyProxy> {

	public interface MyView extends View {
		public AddressDTO getAddressDTO();
		public SubmitButton getValidateButton();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.address)
	public interface MyProxy extends ProxyPlace<ViewAddressPresenter> {
	}

	@Inject
	public ViewAddressPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		getView().getValidateButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getView().getAddressDTO();
				
			}
		});
	}
}
