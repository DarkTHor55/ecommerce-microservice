package com.darkthor.Request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineRequest {
    private Integer id;
    private int orderId;
    private int productId;
    private double quantity;


}
