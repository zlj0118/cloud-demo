package com.shopping.dev.entity;


public class ItemParamItem {

  private Long id;
  private Long itemId;
  private String paramData;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
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

}
