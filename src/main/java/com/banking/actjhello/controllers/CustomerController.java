package com.banking.actjhello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banking.actjhello.models.Customer;
import com.banking.actjhello.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
    return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
  }

  @GetMapping(value = "/get/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
    return new ResponseEntity<Customer>(customerService.getCustomer(id), HttpStatus.OK);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id,
      @RequestBody Customer customer) {
    return new ResponseEntity<Customer>(customerService.updateCustomer(id, customer),
        HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteCustomer(@PathVariable Integer id) {
    customerService.deleteCustomer(id);
  }
}
