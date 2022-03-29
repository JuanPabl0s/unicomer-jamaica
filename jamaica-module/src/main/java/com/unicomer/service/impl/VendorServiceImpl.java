package com.unicomer.service.impl;

import com.unicomer.domain.Vendor;
import com.unicomer.error.ResourceNotFoundException;
import com.unicomer.repository.IVendorRepository;
import com.unicomer.request.VendorRequest;
import com.unicomer.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private IVendorRepository iVendorRepository;

    @Override
    public void saveVendor(VendorRequest vendorRequest) {
        log.info("Creating Vendor with request [{}]", vendorRequest);
        try{
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
            log.info("Vendor created successfully [{}]");
        }catch (Exception e){
            log.error("Error saving the Vendor");
            throw new ServiceException("Error calling the repository", e);
        }
    }

    @Override
    public void update(Long id, VendorRequest vendorRequest) {
        try{

            Vendor vendor = (iVendorRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Vendor not found")));

            Optional<Vendor> vendorOpt =  iVendorRepository.findById(vendorRequest.getId());

            if(vendorOpt.isPresent()) {
                Vendor vendorBuilder = Vendor.builder()
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

                iVendorRepository.save(vendorBuilder);
                log.info("Vendor updated successfully [{}]", vendorRequest.getId());
            }
        }catch(Exception e){
            log.error("Error updating the Vendor");
            throw new ServiceException("Error calling the repository", e);
        }
    }

    @Override
    public Vendor findById(Long id) {

        try{
            Vendor vendor = (iVendorRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Vendor not found")));
            return  vendor;
        }catch(Exception e) {
            log.error("Error searching the Vendor");
            throw new ServiceException("Error calling the repository", e);
        }
    }

    @Override
    public List<Vendor> getAll(){
        log.info("Listing all vendors");
        return iVendorRepository.findAll();
    }
}
