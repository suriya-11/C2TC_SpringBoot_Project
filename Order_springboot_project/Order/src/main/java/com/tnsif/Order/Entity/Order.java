package com.tnsif.Order.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Order {
	@Id
    @Column(name = "Order_Id")
    private int orderId;

    @Column(name = "Order_Name")
    private String orderName;

    @Column(name = "Order_Amount")
    private double orderAmount;

    @Column(name = "Customer_Name")
    private String customerName;

    public Order() {
        super();
    }

    public Order(int orderId, String orderName, double orderAmount, String customerName) {
        super();
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderAmount = orderAmount;
        this.customerName = customerName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderAmount=" + orderAmount
                + ", customerName=" + customerName + "]";
    }

}
