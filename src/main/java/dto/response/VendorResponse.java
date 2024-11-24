package dto.response;

import java.util.UUID;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorResponse {
    private UUID vendorid;
    private String firstname;
    private String lastname;
    private String taxIdentificationNumber;
    private String phonenumber;
    private String email;
    private String bankAccount;
    private String bank;
    private String note;
    private VendorAddressResponse vendorAddress;

    public VendorResponse(model.Vendor vendor) {
        this.vendorid = vendor.getVendorid();
        this.firstname = vendor.getFirstname();
        this.lastname = vendor.getLastname();
        this.taxIdentificationNumber = vendor.getTaxIdentificationNumber();
        this.phonenumber = vendor.getPhonenumber();
        this.email = vendor.getEmail();
        this.bankAccount = vendor.getBankAccount();
        this.bank = vendor.getBank();
        this.note = vendor.getNote();
        if (vendor.getVendorAddress() != null) {
            this.vendorAddress = new VendorAddressResponse(vendor.getVendorAddress());
        }
    }

	public UUID getVendorid() {
		return vendorid;
	}

	public void setVendorid(UUID vendorid) {
		this.vendorid = vendorid;
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

	public VendorAddressResponse getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(VendorAddressResponse vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
    
    
}
