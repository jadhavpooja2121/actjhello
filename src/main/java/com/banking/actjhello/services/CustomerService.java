package com.banking.actjhello.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import com.banking.actjhello.models.Customer;
import com.banking.actjhello.repositories.CustomerRepository;

@Service
public class CustomerService {
  
  @Autowired
  private CustomerRepository customerRepository;
  
  public Customer saveCustomer(Customer customer) {
    return customerRepository.save(customer);
  }
  // get
  public Customer getCustomer(Integer id) {
    Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceAccessException("not found"));
    return customer;
  }

  public Customer updateCustomer(Integer id, Customer customer) {
    Customer existingCustomer = getCustomer(id);
    existingCustomer.setName(customer.getName());
    return customerRepository.save(existingCustomer);
  }
  
  public void deleteCustomer(Integer id) {
    customerRepository.deleteById(id);
  }
}
