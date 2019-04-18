package net.wanho.pojo;

import net.wanho.pojo.base.BaseEntity;

import java.io.Serializable;

public class Orderdetail extends BaseEntity implements Serializable {


    private Long orderid;

    private Long productid;

    private Integer quantity;

    private Float cost;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}