package com.unicomer.service;

import com.unicomer.domain.Vendor;
import com.unicomer.request.VendorRequest;

import java.util.List;

public interface VendorService {

    void saveVendor(VendorRequest vendorRequest);

    void update(Long id, VendorRequest vendorRequest);

    Vendor  findById(Long id);

    List<Vendor> getAll();
}
