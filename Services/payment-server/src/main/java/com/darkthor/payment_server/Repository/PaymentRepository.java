package com.darkthor.payment_server.Repository;

import com.darkthor.payment_server.Controller.PaymentController;
import com.darkthor.payment_server.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
