package com.darkthor.customer_server.Request;

import com.darkthor.customer_server.Model.Address;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class CustomerRequest{
        Long id;
        @NotNull(message = "customer firstname is required")
        String firstname;
        @NotNull(message = "customer lastname is required")
        String lastname;
        @NotNull(message = "customer email is required avalid email address")
        String email;
        Address address;


    }
