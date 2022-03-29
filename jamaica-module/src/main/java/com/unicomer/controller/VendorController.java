package com.unicomer.controller;

import com.unicomer.domain.Vendor;
import com.unicomer.request.VendorRequest;
import com.unicomer.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    public void createVendor(VendorRequest vendorRequest){

         vendorService.saveVendor(vendorRequest);
    }

}
