package model;

import lombok.Builder;

@Builder
public class OrderData {
    private String OrderId;

    public OrderData(String orderId) {
        this.OrderId = orderId;
    }

    public String OrderId() {
        return this.OrderId;
    }

}