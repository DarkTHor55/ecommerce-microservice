package com.darkthor.customer_server.Service;

import com.darkthor.customer_server.Model.Customer;
import com.darkthor.customer_server.Repository.CustomerRepository;
import com.darkthor.customer_server.Request.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final CustomerMapper mapper;

    public Customer createCustomer(CustomerRequest request) {
        Customer customer =mapper.toCustomer(request) ;
        if (customer!=null){
            return customerRepository.save(customer);
        }else {
            return null;
        }
    }

    public Customer updateCustomer(CustomerRequest request) {
        Customer customer = customerRepository.findById(request.getId()).orElseThrow(null);
        if (customer!=null){
            customer.setFirstname(request.getFirstname());
            customer.setLastname(request.getLastname());
            customer.setEmail(request.getEmail());
            customer.setAddress(request.getAddress());
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }

    public boolean isCustomerPresnt(Long id) {
        return customerRepository.existsById(id);
    }

    public Customer deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(null);
        if (customer!=null){
            customerRepository.delete(customer);
            return customer;
        } else {
            return null;
        }
    }
}
