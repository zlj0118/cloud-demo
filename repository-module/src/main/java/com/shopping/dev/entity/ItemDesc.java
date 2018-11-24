package com.shopping.dev.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_item_desc")
public class ItemDesc {

  @Id
  private Long itemId;
  private String itemDesc;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;

  public ItemDesc() {
  }

  public ItemDesc(Long itemId, String itemDesc, Timestamp created) {
    this.itemId = itemId;
    this.itemDesc = itemDesc;
    this.created = created;
  }

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }


  public String getItemDesc() {
    return itemDesc;
  }

  public void setItemDesc(String itemDesc) {
    this.itemDesc = itemDesc;
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
