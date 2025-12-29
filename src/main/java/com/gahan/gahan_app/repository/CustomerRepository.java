package com.gahan.gahan_app.repository;

import com.gahan.gahan_app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}