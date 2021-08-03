package com.invillia.store.product.entities;

import java.math.BigDecimal;

public enum PriceModifierType {
    FLAT,
    PERCENTAGE;

    public BigDecimal apply(BigDecimal price, BigDecimal priceModifier) {
        return switch (this) {
            case FLAT -> price.add(priceModifier);
            case PERCENTAGE -> new BigDecimal(1).add(priceModifier).multiply(price);
        };
    }
}
