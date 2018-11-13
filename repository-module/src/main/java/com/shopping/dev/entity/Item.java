package com.shopping.dev.entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;

@Entity
@Table(name = "tb_item")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field("itemId")
    private Long id;
    @Field("title")
    private String title;
    @Field("sellPoint")
    private String sellPoint;
    @Field("price")
    private Long price;
    @Field("num")
    private Long num;
    @Field("barcode")
    private String barcode;
    @Field("image")
    private String image;
    @Field("cid")
    private Long cid;
    @Field("status")
    private Long status;
    @Field("created")
    private java.sql.Timestamp created;
    @Field("updated")
    private java.sql.Timestamp updated;
=======
import javax.persistence.*;

@Entity
@Table(name = "tb_item")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String sellPoint;
  private Long price;
  private Long num;
  private String barcode;
  private String image;
  private Long cid;
  private Long status;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;
>>>>>>> b81c5193a90d33e8ae00178a7b2b64f5205c43d0


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }


    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }


    public java.sql.Timestamp getCreated() {
        return created;
    }

    public void setCreated(java.sql.Timestamp created) {
        this.created = created;
    }


    public java.sql.Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(java.sql.Timestamp updated) {
        this.updated = updated;
    }

}
