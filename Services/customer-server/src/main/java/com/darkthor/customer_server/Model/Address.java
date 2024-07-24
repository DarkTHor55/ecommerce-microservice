package com.darkthor.customer_server.Model;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Validated
@Embeddable
public class Address {
    private String street;
    private String houseNumber;
    private String ZipCode;

}
