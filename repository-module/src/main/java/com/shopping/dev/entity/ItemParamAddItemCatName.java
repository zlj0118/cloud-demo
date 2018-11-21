package com.shopping.dev.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

public interface ItemParamAddItemCatName {
     String getItemCatName();
     Long getId();
     Long getItemCatId();
     String getParamData();
     java.sql.Timestamp getCreated();
     @JsonInclude(JsonInclude.Include.NON_NULL)
     java.sql.Timestamp getUpdated();
}
