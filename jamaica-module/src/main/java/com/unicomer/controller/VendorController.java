package com.unicomer.controller;

import com.unicomer.domain.Vendor;
import com.unicomer.request.VendorRequest;
import com.unicomer.service.VendorService;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/vendor")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService){
        this.vendorService=vendorService;
    }

    @Operation(description = "List All Method")
    @ApiResponse(code = 400, message = "Bad Request")
    @GetMapping
    public List<Vendor> getAll(){
        log.info("Obtaining all Vendors");
        return vendorService.getAll();
    }

    @Operation(description = "Create Method")
    @ApiResponse(code = 400, message = "Bad Request")
    @PostMapping
    public void createVendor(VendorRequest vendorRequest){
        log.info("Creating Vendor");
         vendorService.saveVendor(vendorRequest);
    }

    @Operation(description = "Update Method")
    @ApiResponse(code = 400, message = "Bad Request")
    @PutMapping
    public void updateVendor(@RequestParam Long id, @RequestBody VendorRequest vendorRequest){
        log.info("Updating Vendor");
        vendorService.update(id,vendorRequest);
    }

    @Operation(description = "Get by Id Method")
    @ApiResponse(code = 400, message = "Bad Request")
    @GetMapping("/{id}")
    public Vendor getById(@RequestParam Long id){
        log.info("Searching vendor");
        return  vendorService.findById(id);
    }

}
