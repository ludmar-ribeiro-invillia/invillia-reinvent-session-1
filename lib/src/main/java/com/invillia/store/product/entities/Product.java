package com.invillia.store.product.entities;

import java.math.BigDecimal;
import java.util.UUID;

public interface Product {
    UUID getId();
    String getSku();
    BigDecimal getPreTaxPrice();
    BigDecimal getTaxRate();
    String getName();
    String getDescription();

    default BigDecimal price() {
        return new BigDecimal("1")
                .add(getTaxRate())
                .multiply(getPreTaxPrice());
    }
}