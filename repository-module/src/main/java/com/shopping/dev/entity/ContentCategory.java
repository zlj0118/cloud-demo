package com.shopping.dev.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_contentCategory")
public class ContentCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long parentId;
  private String name;
  private Long status;
  private Long sortOrder;
  private Long isParent;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;

  public ContentCategory() {
  }

  public ContentCategory(Long parentId, String name, Long status, Long sortOrder, Long isParent, Timestamp created, Timestamp updated) {
    this.parentId = parentId;
    this.name = name;
    this.status = status;
    this.sortOrder = sortOrder;
    this.isParent = isParent;
    this.created = created;
    this.updated = updated;
  }

  @Override
  public String toString() {
    return "ContentCategory{" +
            "id=" + id +
            ", parentId=" + parentId +
            ", name='" + name + '\'' +
            ", status=" + status +
            ", sortOrder=" + sortOrder +
            ", isParent=" + isParent +
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


  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }


  public Long getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(Long sortOrder) {
    this.sortOrder = sortOrder;
  }


  public Long getIsParent() {
    return isParent;
  }

  public void setIsParent(Long isParent) {
    this.isParent = isParent;
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
