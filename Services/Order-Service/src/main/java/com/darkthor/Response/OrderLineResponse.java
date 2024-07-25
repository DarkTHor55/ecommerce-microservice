package com.darkthor.Response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor@NoArgsConstructor
@Builder
public class OrderLineResponse {
    private int id;
    private double quantity;
}
