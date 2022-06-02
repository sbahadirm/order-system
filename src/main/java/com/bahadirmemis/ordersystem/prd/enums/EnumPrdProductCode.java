package com.bahadirmemis.ordersystem.prd.enums;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public enum EnumPrdProductCode {

    FOOD("Food"),
    DRINK("Drink"),
    OTHER("Other")
    ;

    private String productCode;

    EnumPrdProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    @Override
    public String toString() {
        return productCode;
    }
}
