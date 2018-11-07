package com.shopping.dev.entity;


public class ItemDesc {

  private Long itemId;
  private String itemDesc;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;


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
