package com.invillia.store.product.entities;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ProductBundle implements Product {
    private UUID id;
    private String sku;
    private BigDecimal taxRate;
    private String name;
    private String description;
    private PriceModifierType priceModifierType;
    private BigDecimal priceModifier;
    private List<Product> items;
    private List<Product> giftItems;

    public ProductBundle(
            UUID id,
            String sku,
            BigDecimal taxRate,
            String name,
            String description,
            PriceModifierType priceModifierType,
            BigDecimal priceModifier,
            List<Product> items,
            List<Product> giftItems
    ) {
        this.id = id;
        this.sku = sku;
        this.taxRate = taxRate;
        this.name = name;
        this.description = description;
        this.priceModifierType = priceModifierType;
        this.priceModifier = priceModifier;
        this.items = Collections.unmodifiableList(items);
        this.giftItems = Collections.unmodifiableList(giftItems);
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
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public BigDecimal getPreTaxPrice() {
        return items
                .stream()
                .map(Product::getPreTaxPrice)
                .reduce(new BigDecimal(0), BigDecimal::add);
    }

    @Override
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("1").add(taxRate).multiply(
                priceModifierType.apply(
                        getPreTaxPrice(),
                        priceModifier
                )
        );
    }

    public PriceModifierType getPriceModifierType() {
        return priceModifierType;
    }

    public BigDecimal getPriceModifier() {
        return priceModifier;
    }

    public List<Product> getItems() {
        //return Collections.unmodifiableList(items);

        return new LinkedList<>(items);
    }

    public List<Product> getGiftItems() {
        return new LinkedList<>(giftItems);
    }
}
