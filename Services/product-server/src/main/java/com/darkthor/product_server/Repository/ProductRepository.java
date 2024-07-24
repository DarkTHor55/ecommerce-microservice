package com.darkthor.product_server.Repository;

import com.darkthor.product_server.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAllByIdInOrderById(List<Integer> responses);
}
