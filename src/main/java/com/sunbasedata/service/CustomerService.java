package com.sunbasedata.service;

import com.sunbasedata.dao.CustomerDao;
import com.sunbasedata.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
      @Autowired
      private CustomerDao customerDao;

      public CustomerEntity saveCustomer(CustomerEntity customerEntity){
         return customerDao.save(customerEntity);
      }

    public Iterable<CustomerEntity> listOfCompanyDetails(CustomerEntity customerEntity){
        return customerDao.findAll();
    }


    public CustomerEntity deleteCustomer(Integer id){
        Optional<CustomerEntity> cmp =  customerDao.findById(id);
        if(cmp.isPresent()){
            customerDao.deleteById(id);
            return  null;

        }else {
            return  null;
        }
    }
   public CustomerEntity updateCustomerById(Integer id){
       Optional<CustomerEntity> cmp =  customerDao.findById(id);
       return cmp.get();
   }

}
