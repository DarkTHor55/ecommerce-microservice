package com.darkthor.Customer;

import com.darkthor.Response.CustomerResponse;
import jakarta.ws.rs.Path;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "customer-service",url = "${application.config.customer-url}")
public interface CustomerClient {
    @GetMapping("/{id}")
    public Optional<CustomerResponse> findCustomerById(@PathVariable("id") String id);
}
