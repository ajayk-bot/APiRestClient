package com.stripe.version.pojo;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {

    public String city;
    public String country;
    public String line1;
    public String line2;
    public String postal_code;
    public String state;
}
