package com.shopping.dev.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_item_param")
public class ItemParam {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long itemCatId;
  private String paramData;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;
  private int status;

  public ItemParam() {
  }

  public ItemParam(Long itemCatId, String paramData, Timestamp created, Timestamp updated) {
    this.itemCatId = itemCatId;
    this.paramData = paramData;
    this.created = created;
    this.updated = updated;
  }

  @Override
  public String toString() {
    return "ItemParam{" +
            "id=" + id +
            ", itemCatId=" + itemCatId +
            ", paramData='" + paramData + '\'' +
            ", created=" + created +
            ", updated=" + updated +
            '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getItemCatId() {
    return itemCatId;
  }

  public void setItemCatId(Long itemCatId) {
    this.itemCatId = itemCatId;
  }


  public String getParamData() {
    return paramData;
  }

  public void setParamData(String paramData) {
    this.paramData = paramData;
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

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
