package com.darkthor.Response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponse {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
}
