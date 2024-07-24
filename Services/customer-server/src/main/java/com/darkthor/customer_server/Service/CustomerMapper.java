package com.darkthor.customer_server.Service;

import com.darkthor.customer_server.Model.Customer;
import com.darkthor.customer_server.Request.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if (request==null){
            return null;
        }
        return Customer.builder()
                .id(request.getId())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();
    }
}
