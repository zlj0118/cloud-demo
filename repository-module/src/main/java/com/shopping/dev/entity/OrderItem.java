package com.shopping.dev.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_order_item")
@Data
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String itemId;
    private String orderId;
    private Long num;
    private String title;
    private Long price;
    private Long totalFee;
    private String picPath;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Item.class)
    @JoinColumn(name = "itemId", referencedColumnName = "id", updatable = false, insertable = false)
    private Item item;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", itemId='" + itemId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", totalFee=" + totalFee +
                ", picPath='" + picPath + '\'' +
                ", items=" + item +
                '}';
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }


    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

}
