package com.invillia.store.product.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ProductTest {

    @Test
    public void testPriceCalculation() {

        Product product = new RegularProduct(
                UUID.randomUUID(),
                "123456789",
                new BigDecimal("100"),
                new BigDecimal("0.2"),
                "banana",
                "A juicy banana"
        );

        assertEquals(new BigDecimal("120").stripTrailingZeros(), product.price().stripTrailingZeros());
    }

    @Test
    public void testSpecialConditionProduct() {

        Product regularProduct = new RegularProduct(
                UUID.randomUUID(),
                "123456789",
                new BigDecimal("100"),
                new BigDecimal("0.2"),
                "banana",
                "A juicy banana"
        );

        Product returnedProduct = new SpecialConditionProduct(
                UUID.randomUUID(),
                "12345678901",
                regularProduct,
                ConditionType.RETURNED,
                PriceModifierType.PERCENTAGE,
                new BigDecimal("-0.5"),
                "returned",
                "this banana was returned, you are buying well knowing the implications of this order"
        );

        Product promotionalProduct = new SpecialConditionProduct(
                UUID.randomUUID(),
                "12345678901",
                regularProduct,
                ConditionType.PROMOTIONAL,
                PriceModifierType.FLAT,
                new BigDecimal("-10"),
                "sale",
                "this offer is a special limited offer"
        );

        assertEquals("[returned] banana", returnedProduct.getName());
        assertEquals(
                "A juicy banana\n\nthis banana was returned, you are buying well knowing the implications of this order",
                returnedProduct.getDescription()
        );
        assertEquals(new BigDecimal("60").stripTrailingZeros(), returnedProduct.price().stripTrailingZeros());

        assertEquals("[sale] banana", promotionalProduct.getName());
        assertEquals(
                "A juicy banana\n\nthis offer is a special limited offer",
                promotionalProduct.getDescription()
        );
        assertEquals(new BigDecimal("108").stripTrailingZeros(), promotionalProduct.price().stripTrailingZeros());
    }

    @Test
    public void testProductBundle() {

        Product regularProduct = new RegularProduct(
                UUID.randomUUID(),
                "123456789",
                new BigDecimal("100"),
                new BigDecimal("0.2"),
                "banana",
                "A juicy banana"
        );

        List<Product> items = Arrays.asList(
                regularProduct,
                regularProduct,
                regularProduct
        );

        List<Product> giftItems = List.of(
                regularProduct
        );

        Product bundle = new ProductBundle(
                UUID.randomUUID(),
                "12345678902",
                new BigDecimal("0.3"),
                "Buy 4 pay 3 bananas",
                "4 juicy bananas",
                PriceModifierType.FLAT,
                BigDecimal.ZERO,
                items,
                giftItems
        );

        assertEquals(new BigDecimal("300").stripTrailingZeros(), bundle.getPreTaxPrice().stripTrailingZeros());
        assertEquals(new BigDecimal("0.3").stripTrailingZeros(), bundle.getTaxRate().stripTrailingZeros());
        assertEquals(new BigDecimal("390").stripTrailingZeros(), bundle.price().stripTrailingZeros());
    }

    @Test
    public void testProductBundleWithFlatDiscount() {

        Product regularProduct = new RegularProduct(
                UUID.randomUUID(),
                "123456789",
                new BigDecimal("100"),
                new BigDecimal("0.2"),
                "banana",
                "A juicy banana"
        );

        List<Product> items = Arrays.asList(
                regularProduct,
                regularProduct,
                regularProduct
        );

        List<Product> giftItems = Arrays.asList(
                regularProduct
        );

        Product bundle = new ProductBundle(
                UUID.randomUUID(),
                "12345678902",
                new BigDecimal("0.3"),
                "Buy 4 pay 3 bananas",
                "4 juicy bananas",
                PriceModifierType.FLAT,
                new BigDecimal("-60"),
                items,
                giftItems
        );

        assertEquals(new BigDecimal("300").stripTrailingZeros(), bundle.getPreTaxPrice().stripTrailingZeros());
        assertEquals(new BigDecimal("0.3").stripTrailingZeros(), bundle.getTaxRate().stripTrailingZeros());
        assertEquals(new BigDecimal("312").stripTrailingZeros(), bundle.price().stripTrailingZeros());
    }

    @Test
    public void testProductBundleWithPercentageDiscount() {

        Product regularProduct = new RegularProduct(
                UUID.randomUUID(),
                "123456789",
                new BigDecimal("100"),
                new BigDecimal("0.2"),
                "banana",
                "A juicy banana"
        );

        List<Product> items = Arrays.asList(
                regularProduct,
                regularProduct,
                regularProduct
        );

        List<Product> giftItems = Arrays.asList(
                regularProduct
        );

        Product bundle = new ProductBundle(
                UUID.randomUUID(),
                "12345678902",
                new BigDecimal("0.3"),
                "Buy 4 pay 3 bananas",
                "4 juicy bananas",
                PriceModifierType.PERCENTAGE,
                new BigDecimal("-0.25"),
                items,
                giftItems
        );

        assertEquals(new BigDecimal("300").stripTrailingZeros(), bundle.getPreTaxPrice().stripTrailingZeros());
        assertEquals(new BigDecimal("0.3").stripTrailingZeros(), bundle.getTaxRate().stripTrailingZeros());
        assertEquals(new BigDecimal("292.5").stripTrailingZeros(), bundle.price().stripTrailingZeros());
    }
}
