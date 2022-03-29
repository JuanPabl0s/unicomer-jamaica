package com.unicomer.service.impl;

import com.unicomer.domain.Vendor;
import com.unicomer.repository.IVendorRepository;
import com.unicomer.request.VendorRequest;
import com.unicomer.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private IVendorRepository iVendorRepository;

    @Override
    public void saveVendor(VendorRequest vendorRequest) {
        log.info("Creating Vendor with request [{}]", vendorRequest);

        Vendor vendor = Vendor.builder()
                .firstName(vendorRequest.getFirstName())
                .lastName(vendorRequest.getLastName())
                .birthDay(vendorRequest.getBirthDay())
                .gender(vendorRequest.getGender())
                .cellphone(vendorRequest.getCellphone())
                .homePhone(vendorRequest.getHomePhone())
                .addressHome(vendorRequest.getAddressHome())
                .profession(vendorRequest.getProfession())
                .incomes(vendorRequest.getIncomes())
                .build();

        iVendorRepository.save(vendor);

    }
}
