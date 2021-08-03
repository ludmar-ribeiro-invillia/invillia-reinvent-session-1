package com.invillia.store.product.entities;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class RegularProduct implements Product {
    private UUID id;
    private String sku;
    private BigDecimal preTaxPrice;
    private BigDecimal taxRate;
    private String name;
    private String description;

    public RegularProduct(
            UUID id,
            String sku,
            BigDecimal preTaxPrice,
            BigDecimal taxRate,
            String name,
            String description
    ) {
        this.id = id;
        this.sku = sku;
        this.preTaxPrice = preTaxPrice;
        this.taxRate = taxRate;
        this.name = name;
        this.description = description;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getSku() {
        return sku;
    }

    @Override
    public BigDecimal getPreTaxPrice() {
        return preTaxPrice;
    }

    @Override
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        RegularProduct that = (RegularProduct) other;
        return id.equals(that.id)
                && sku.equals(that.sku)
                && preTaxPrice.equals(that.preTaxPrice)
                && taxRate.equals(that.taxRate)
                && name.equals(that.name)
                && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                sku,
                preTaxPrice,
                taxRate,
                name,
                description
        );
    }
}
