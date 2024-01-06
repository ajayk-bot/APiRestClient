package com.stripe.version.pojo;

import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {

    //public String id;
    //public String object;
    public Address address;
    public int balance;
    public int created;
    public String currency;
    public Object default_source;
    public boolean delinquent;
    public String description;
    public Object discount;
    public String email;
    public String invoice_prefix;
    public InvoiceSettings invoice_settings;
    public boolean livemode;
    public Metadata metadata;
    public String name;
    public int next_invoice_sequence;
    public String phone;
    public ArrayList<String> preferred_locales;
    public Shipping shipping;
    public String tax_exempt;
    public Object test_clock;
}
