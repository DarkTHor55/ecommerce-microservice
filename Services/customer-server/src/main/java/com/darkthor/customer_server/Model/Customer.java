package com.darkthor.customer_server.Model;

import jakarta.persistence.*;
import lombok.*;

import java.lang.annotation.Documented;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Embedded
    private Address address;
    private String email;

}
