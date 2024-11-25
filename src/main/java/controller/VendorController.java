package controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.requests.VendorCreationRequest;
import dto.response.VendorResponse;
import service.VendorService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/vendor")
@CrossOrigin(origins = "http://localhost:3000")
public class VendorController {
    
    private VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // Trang Home - Hiển thị danh sách Vendor
    @GetMapping("/home")
    public String getListVendor(Model model) {
        List<VendorResponse> vendors = vendorService.getAllVendors();
        model.addAttribute("vendors", vendors);
        return "vendor/home";
    }
}