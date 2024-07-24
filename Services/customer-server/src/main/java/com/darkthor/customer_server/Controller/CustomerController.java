package com.darkthor.customer_server.Controller;

import com.darkthor.customer_server.Model.Customer;
import com.darkthor.customer_server.Request.CustomerRequest;
import com.darkthor.customer_server.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<String>createCustomer(@RequestBody @Valid CustomerRequest request){
        Customer customer =customerService.createCustomer(request);
        if(customer==null){
            return ResponseEntity.badRequest().body("Invalid customer data");
        }else{
            return ResponseEntity.ok("Customer created successfully");
        }
    }
    @PutMapping()
    public ResponseEntity<String> updateCustomer(@RequestBody @Valid CustomerRequest request){
        Customer customer = customerService.updateCustomer(request);
        if(customer==null){
            return ResponseEntity.badRequest().body("Invalid customer data");
        }else{
            return ResponseEntity.ok("Customer updated successfully");
        }
    }
    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomer(@RequestParam Long id){
        List<Customer> customers = customerService.allCustomer();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        boolean b=customerService.isCustomerPresnt(id);
        if (b){
            Customer customer = customerService.allCustomer().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
            if(customer==null){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(customer);
            }
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> isPresnt(@PathVariable("id") Long id){
        boolean b=customerService.isCustomerPresnt(id);
        if (b){
            return ResponseEntity.ok(true);
        }else {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestParam Long id){
        boolean b=customerService.isCustomerPresnt(id);
        if (b){
            Customer customer = customerService.deleteCustomer(id);
            if(customer==null){
                return new ResponseEntity<>("Customer Not found",HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>("Customer Deleted Successfully",HttpStatus.NOT_FOUND);
            }
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
