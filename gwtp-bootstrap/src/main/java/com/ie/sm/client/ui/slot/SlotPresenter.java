package com.ie.sm.client.ui.slot;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;
import com.ie.sm.client.place.NameTokens;

public class SlotPresenter extends
		Presenter<SlotPresenter.MyView, SlotPresenter.MyProxy> {

	public static final Object TYPE_RevealTopBarContent = new Object();
	
	public interface MyView extends View {
	}

	
	@ProxyCodeSplit
	@NameToken(NameTokens.slot)
	public interface MyProxy extends ProxyPlace<SlotPresenter> {
	}

//	private AddOwnerContactEditorPresenter testEditorPresenter;
	
	@Inject
	public SlotPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy ) { //, AddOwnerContactEditorPresenter testEditorPresenter) {
		super(eventBus, view, proxy);
//		this.testEditorPresenter = testEditorPresenter;
	}

	@Override
	protected void revealInParent() {
		RevealRootLayoutContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		
//		setInSlot(TYPE_RevealTopBarContent, testEditorPresenter);
	}
}
