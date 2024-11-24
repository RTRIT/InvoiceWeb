package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.requests.VendorCreationRequest;
import dto.response.VendorResponse;
import exception.AppException;
import exception.ErrorCode;
import repository.VendorAddressRepository;
import repository.VendorRepository;
import model.Vendor;
import model.VendorAddress;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorAddressRepository vendorAddressRepository;

    public List<Vendor> searchVendor(String name, String email, String phonenumber) {
        if (name==null && email==null && phonenumber==null) {
            throw new AppException(ErrorCode.INVALID_SEARCH_CRITERIA);
        }

        List<Vendor> vendors = vendorRepository.searchVendor(name, phonenumber, email);

        if (vendors.isEmpty()){
            throw new AppException(ErrorCode.VENDOR_NOT_FOUND);
        }
        return vendors;
    }

    public VendorResponse getVendorByVendorID(UUID vendorid) {
        if (vendorid == null) {
            throw new AppException(ErrorCode.VENDOR_NOT_FOUND);
        }
        Vendor vendor = vendorRepository.findByVendorid(vendorid)
                .orElseThrow(() -> new AppException(ErrorCode.VENDOR_NOT_FOUND));
        return new VendorResponse(vendor);
    }


    // Get all vendors
    public List<VendorResponse> getAllVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        return vendors.stream().map(VendorResponse::new).collect(Collectors.toList());
    }

    // Create Vendor, check email and phonenumber exist
    public VendorResponse createVendor(VendorCreationRequest request) {
        if (vendorRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        if (vendorRepository.existsByPhonenumber(request.getPhonenumber())) {
            throw new AppException(ErrorCode.PHONENUMBER_EXISTED);
        }

        Vendor vendor = new Vendor();
        vendor.setFirstname(request.getFirstname());
        vendor.setLastname(request.getLastname());
        vendor.setTaxIdentificationNumber(request.getTaxIdentificationNumber());
        vendor.setPhonenumber(request.getPhonenumber());
        vendor.setEmail(request.getEmail());
        vendor.setBankAccount(request.getBankAccount());
        vendor.setBank(request.getBank());
        vendor.setNote(request.getNote());

        if (request.getVendorAddress() != null) {
            VendorAddress vendorAddress = new VendorAddress();
            vendorAddress.setStreet(request.getVendorAddress().getStreet());
            vendorAddress.setCity(request.getVendorAddress().getCity());
            vendorAddress.setCountry(request.getVendorAddress().getCountry());
            vendorAddress.setPostCode(request.getVendorAddress().getPostCode());
            vendorAddressRepository.save(vendorAddress);
            vendor.setVendorAddress(vendorAddress);
        }

        vendorRepository.save(vendor);
        return new VendorResponse(vendor);
    }

    

    public VendorResponse updateVendor(UUID vendorid, VendorCreationRequest request) {
        Vendor vendor = vendorRepository.findByVendorid(vendorid).orElse(null);
        if (vendor == null){
            throw new RuntimeException("Vendor cannot be null");
        }
        vendor.setFirstname(request.getFirstname());
        vendor.setLastname(request.getLastname());
        vendor.setTaxIdentificationNumber(request.getTaxIdentificationNumber());
        vendor.setPhonenumber(request.getPhonenumber());
        vendor.setEmail(request.getEmail());
        vendor.setBankAccount(request.getBankAccount());
        vendor.setBank(request.getBank());
        vendor.setNote(request.getNote());

        if (request.getVendorAddress() != null) {
            VendorAddress vendorAddress = vendor.getVendorAddress();
            if (vendorAddress == null) {
                vendorAddress = new VendorAddress();
            }
            vendorAddress.setStreet(request.getVendorAddress().getStreet());
            vendorAddress.setCity(request.getVendorAddress().getCity());
            vendorAddress.setCountry(request.getVendorAddress().getCountry());
            vendorAddress.setPostCode(request.getVendorAddress().getPostCode());
            vendorAddressRepository.save(vendorAddress);
            vendor.setVendorAddress(vendorAddress);
        }

        vendorRepository.save(vendor);
        return new VendorResponse(vendor);
    }

    public void deleteVendor(UUID vendorid) {
        vendorRepository.deleteById(vendorid);
    }
}
