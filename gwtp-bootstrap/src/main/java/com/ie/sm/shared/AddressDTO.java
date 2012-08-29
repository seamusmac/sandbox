package com.ie.sm.shared;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressDTO {

	@NotNull
	@Size(min=1)
	public String addressLine1;
	@NotNull
	public String addressLine2;
	@NotNull
	public String addressLine3;
	public String addressLine4;
	public String statecounty;
	public String postcode;

	@NotNull
	public String country;

	public AddressDTO() {
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public String getStatecounty() {
		return statecounty;
	}

	public void setStatecounty(String statecounty) {
		this.statecounty = statecounty;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
