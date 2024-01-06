package com.stripe.version.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Shipping {
    public Address address;
    public String name;
    public Object phone;
}
