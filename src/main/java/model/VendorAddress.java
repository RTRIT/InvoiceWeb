package model;


import jakarta.persistence.*;

@Entity
@Table(name = "VendorAddress")
public class VendorAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String postCode;

    @Transient // Không lưu vào DB
    private String fullAddress;

    public VendorAddress() {
    }
    // Khởi tạo và tính toán fullAddress trong constructor
    public VendorAddress(String street, String city, String country, String postCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.fullAddress = calculateFullAddress();
    }

    // Phương thức để tính toán fullAddress
    public String calculateFullAddress() {
        return street + " " + city + " " + country + " " + postCode;
    }

    // Gọi phương thức này nếu các trường khác được thay đổi
    @PostLoad
    @PostPersist
    @PostUpdate
    public void updateFullAddress() {
        this.fullAddress = calculateFullAddress();
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
    
}
