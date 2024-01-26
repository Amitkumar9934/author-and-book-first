package com.webapp.authorid.repository;

import com.webapp.authorid.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
