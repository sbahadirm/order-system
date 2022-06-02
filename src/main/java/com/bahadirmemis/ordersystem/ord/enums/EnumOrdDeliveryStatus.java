package com.bahadirmemis.ordersystem.ord.enums;

public enum EnumOrdDeliveryStatus {

    PREPARING("preparing"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled")
    ;

    private String status;

    EnumOrdDeliveryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
