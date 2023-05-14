package com.banking.actjhello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.actjhello.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
