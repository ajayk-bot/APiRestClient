package com.stripe.version.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InvoiceSettings{
    public Object custom_fields;
    public Object default_payment_method;
    public Object footer;
    public Object rendering_options;
}