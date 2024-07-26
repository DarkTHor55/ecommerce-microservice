package com.darkthor.payment_server.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Builder
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
