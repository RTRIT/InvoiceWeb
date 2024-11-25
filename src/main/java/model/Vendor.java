package model;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;



@Entity
@Table(name = "Vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID vendorid;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, name = "tax_identification_number")
    private String taxIdentificationNumber;

    @Column(nullable = false)
    private String phonenumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "bank_account")
    private String bankAccount;

    @Column(nullable = false)
    private String bank;

    // @Column
    // private String logo;

    @Column
    private String note;

    @OneToMany
    private List<Invoice> invoices;

    @OneToOne(cascade = CascadeType.ALL) // Cascade to automatically persist VendorAddress when Vendor is saved
    @JoinColumn(name = "addr", referencedColumnName = "id", nullable = true) // Allowing nullable for optional address
    private VendorAddress vendorAddress; // Changed to lowercase for consistency

    // Default constructor
    public Vendor() {
    }
    // Constructor without individual address fields
    public Vendor(String firstname, String lastname, String taxIdentificationNumber, String phonenumber, String email, String bankAccount, String bank, VendorAddress vendorAddress, String note) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.phonenumber = phonenumber;
        this.email = email;
        this.bankAccount = bankAccount;
        this.bank = bank;
        //this.logo = logo;
        this.vendorAddress = vendorAddress;
        this.note = note;
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
	public List<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	public VendorAddress getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(VendorAddress vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
    
    
}
