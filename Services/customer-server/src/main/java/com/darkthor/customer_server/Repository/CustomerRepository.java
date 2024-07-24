package com.darkthor.customer_server.Repository;

import com.darkthor.customer_server.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
