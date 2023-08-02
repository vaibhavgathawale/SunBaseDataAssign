package com.sunbasedata.controller;

import com.sunbasedata.entity.CustomerEntity;
import com.sunbasedata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("api/v1/sunbasedata")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp\n")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity){
        customerService.saveCustomer(customerEntity);
        return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
    }
    @GetMapping(" https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp\n")
    public ResponseEntity<CustomerEntity> getCustomerList(@RequestBody CustomerEntity customerEntity ){
             customerService.listOfCompanyDetails(customerEntity);
        return new ResponseEntity<CustomerEntity>(customerEntity,HttpStatus.FOUND);
    }

    @DeleteMapping("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp\n")
    public ResponseEntity<?> removeCompany(@PathVariable Integer id){
               customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(" https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable ("id") Integer id){
                    customerService.updateCustomerById(id);
        return  new ResponseEntity(id,HttpStatus.OK);
    }
}
