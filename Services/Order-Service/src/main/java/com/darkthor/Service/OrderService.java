package com.darkthor.Service;

import com.darkthor.Customer.CustomerClient;
import com.darkthor.Execption.BusinessExecption;
import com.darkthor.Kafka.OrderConfirmation;
import com.darkthor.Kafka.OrderProducer;
import com.darkthor.Model.Orders;
import com.darkthor.Payment.PaymentClient;
import com.darkthor.Payment.PaymentRequest;
import com.darkthor.Product.ProductClient;
import com.darkthor.Repository.OrderRepository;
import com.darkthor.Request.OrderLineRequest;
import com.darkthor.Request.OrderRequest;
import com.darkthor.Request.PurchaseRequest;
import com.darkthor.Response.OrderResonse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    @Autowired
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;
    public Integer createOrder(OrderRequest orderRequest) throws BusinessExecption {
//        Check customer by openFeign
        var customer=this.customerClient.findCustomerById(String.valueOf(orderRequest.getCustomerId())).orElseThrow(()->new BusinessExecption("Cannot create order  :: No customer exists with provided id : "+orderRequest.getCustomerId())) ;

//        Purchase Product by Product-service (RestTemplate)
      var purchasedProduct=  this.productClient.purchaseProduct(orderRequest.getProducts());
        var order=this.orderRepository.save(mapper.toOrder(orderRequest));

        for (PurchaseRequest purchaseRequest:orderRequest.getProducts()) {
                orderLineService.saveOrderLine(new OrderLineRequest(
                        null,
                            order.getId(),
                            purchaseRequest.getProductId(),
                            purchaseRequest.getQuantity()
                )

            );
        }

//       todo start paymentsProcess
        var paymentRequest = new PaymentRequest(
                orderRequest.getAmount(),
                orderRequest.getPaymentMethod(),
                orderRequest.getId(),
                orderRequest.getReference(),
                customer

        );
        paymentClient.requestOrderPayment(paymentRequest);



        orderProducer.sendOrderConformation(
                new OrderConfirmation(
                        orderRequest.getReference(),
                        orderRequest.getAmount(),
                        orderRequest.getPaymentMethod(),
                        customer,purchasedProduct
                )
        );

//      send the order confirmation  bt notification-service (kafka)

        return order.getId();

    }

    public List<OrderResonse> findAll() {
        return orderRepository.findAll().stream().map(mapper::fromOrder).collect(Collectors.toList());
    }

    public OrderResonse findOrderById(int id) throws BusinessExecption {
        Orders order = orderRepository.findById(id).orElseThrow(()->new BusinessExecption("Order Not Found"));
        return OrderResonse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .reference(order.getRefrence())
                .amount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .build();
    }
}
