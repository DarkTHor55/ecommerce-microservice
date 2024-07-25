package com.darkthor.Repository;

import com.darkthor.Model.OrderLine;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {
    List<OrderLine>findAllByOrderId(int orderId);
}
