package dto.requests;


import jakarta.validation.constraints.Email;
import lombok.*;
import model.Vendor;
import model.VendorAddress;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorCreationRequest {

    @Email(message = "Email is not validated!")
    private String firstname;
    private String lastname;
    private String taxIdentificationNumber;
    private String phonenumber;
    private String email;
    private String bankAccount;
    private String bank;
    private String note;
    private VendorAddress vendorAddress;
    
	public Vendor toVendorEntity(VendorCreationRequest request) {
        Vendor vendor = new Vendor();
        vendor.setFirstname(request.getFirstname());
        vendor.setLastname(request.getLastname());
        vendor.setTaxIdentificationNumber(request.getTaxIdentificationNumber());
        vendor.setPhonenumber(request.getPhonenumber());
        vendor.setEmail(request.getEmail());
        vendor.setBankAccount(request.getBankAccount());
        vendor.setBank(request.getBank());
        vendor.setNote(request.getNote());

        // Ánh xạ địa chỉ
        if (request.getVendorAddress() != null) {
            VendorAddress vendorAddress = new VendorAddress();
            vendorAddress.setStreet(request.getVendorAddress().getStreet());
            vendorAddress.setCity(request.getVendorAddress().getCity());
            vendorAddress.setCountry(request.getVendorAddress().getCountry());
            vendorAddress.setPostCode(request.getVendorAddress().getPostCode());
            vendor.setVendorAddress(vendorAddress);
        }

        return vendor;
    }

	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getTaxIdentificationNumber() {
		return taxIdentificationNumber;
	}



	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		this.taxIdentificationNumber = taxIdentificationNumber;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getBankAccount() {
		return bankAccount;
	}



	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}



	public String getBank() {
		return bank;
	}



	public void setBank(String bank) {
		this.bank = bank;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public VendorAddress getVendorAddress() {
		return vendorAddress;
	}



	public void setVendorAddress(VendorAddress vendorAddress) {
		this.vendorAddress = vendorAddress;
	}


}