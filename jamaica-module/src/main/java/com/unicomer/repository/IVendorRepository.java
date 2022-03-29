package com.unicomer.repository;

import com.unicomer.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IVendorRepository extends JpaRepository<Vendor,Long>, JpaSpecificationExecutor<Vendor> {
}
