package com.shopping.dev.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_content_category")
public class ContentCategoryForEasyUiTree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String text;
    private String state;
    @Transient
    private List<ContentCategoryForEasyUiTree> children;
    @JsonIgnore
    private int parentId;

    @Override
    public String toString() {
        return "ContentCategoryForEasyUiTree{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", children=" + children +
                ", parentId=" + parentId +
                '}';
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<ContentCategoryForEasyUiTree> getChildren() {
        return children;
    }

    public void setChildren(List<ContentCategoryForEasyUiTree> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
