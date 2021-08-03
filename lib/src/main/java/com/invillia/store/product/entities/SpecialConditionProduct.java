package com.invillia.store.product.entities;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class SpecialConditionProduct extends RegularProduct {
    private Product originalProduct;
    private ConditionType conditionType;
    private PriceModifierType priceModifierType;
    private BigDecimal priceModifier;
    private String nameAddition;
    private String descriptionDisclaimer;

    public SpecialConditionProduct(
            UUID id,
            String sku,
            Product originalProduct,
            ConditionType conditionType,
            PriceModifierType priceModifierType,
            BigDecimal priceModifier,
            String nameAddition,
            String descriptionDisclaimer
    ) {
        super(
                id,
                sku,
                originalProduct.getPreTaxPrice(),
                originalProduct.getTaxRate(),
                originalProduct.getName(),
                originalProduct.getDescription()
        );

        this.originalProduct = originalProduct;
        this.conditionType = conditionType;
        this.priceModifierType = priceModifierType;
        this.priceModifier = priceModifier;
        this.nameAddition = nameAddition;
        this.descriptionDisclaimer = descriptionDisclaimer;
    }

    public Product getOriginalProduct() {
        return originalProduct;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public PriceModifierType getPriceModifierType() {
        return priceModifierType;
    }

    public BigDecimal getPriceModifier() {
        return priceModifier;
    }

    public String getNameAddition() {
        return nameAddition;
    }

    public String getDescriptionDisclaimer() {
        return descriptionDisclaimer;
    }

    @Override
    public String getName() {
        return "[" + nameAddition + "] " + super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n\n" + descriptionDisclaimer;
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("1").add(super.getTaxRate()).multiply(
                priceModifierType.apply(super.getPreTaxPrice(), priceModifier)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpecialConditionProduct that = (SpecialConditionProduct) o;
        return originalProduct.equals(that.originalProduct)
                && conditionType == that.conditionType
                && priceModifierType == that.priceModifierType
                && priceModifier.equals(that.priceModifier)
                && nameAddition.equals(that.nameAddition)
                && descriptionDisclaimer.equals(that.descriptionDisclaimer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                originalProduct,
                conditionType,
                priceModifierType,
                priceModifier,
                nameAddition,
                descriptionDisclaimer
        );
    }
}
