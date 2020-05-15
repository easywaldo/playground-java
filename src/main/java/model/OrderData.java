package model;

import lombok.Builder;

import javax.persistence.Entity;

@Entity
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