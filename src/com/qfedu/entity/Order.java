package com.qfedu.entity;

public class Order {
    private int id;
    private String orderCode;
    private int totalPrice;
    private String order_status;
    private String createDate;
    private String username;

    public Order() {
    }

    public Order(int id, String orderCode, int totalPrice, String order_status, String createDate, String username) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.order_status = order_status;
        this.createDate = createDate;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", order_status='" + order_status + '\'' +
                ", createDate='" + createDate + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}