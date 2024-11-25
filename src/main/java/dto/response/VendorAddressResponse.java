package dto.response;

public class VendorAddressResponse {
    private String street;
    private String city;
    private String country;
    private String postCode;
    
    public VendorAddressResponse(model.VendorAddress address) {
        this.street = address.getStreet();
        this.city = address.getCity();
        this.country = address.getCountry();
        this.postCode = address.getPostCode();
    }

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
    
    
}
