package com.scosm.repository;

import com.scosm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findCustomerById(int id);

    Optional<Customer> findCustomerByEmail(String email);
}
