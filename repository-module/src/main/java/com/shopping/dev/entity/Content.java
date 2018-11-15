package com.shopping.dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_content")
public class Content {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long categoryId;
  private String title;
  private String subTitle;
  private String titleDesc;
  private String url;
  private String pic;
  private String pic2;
  private String content;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }


  public String getTitleDesc() {
    return titleDesc;
  }

  public void setTitleDesc(String titleDesc) {
    this.titleDesc = titleDesc;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }


  public String getPic2() {
    return pic2;
  }

  public void setPic2(String pic2) {
    this.pic2 = pic2;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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
