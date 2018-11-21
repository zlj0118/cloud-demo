package com.shopping.dev.utils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ObjectArrays;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.thoughtworks.xstream.mapper.ArrayMapper;

public class CheckJson {
    public static boolean checkJsonByFastJson(String json) {
        try {
//            JSONObject.parseObject(json);
            JSONObject.parseArray(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkJsonByJackson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkJsonByGson(String json) {
        Gson gson = new Gson();
        try {
            gson.fromJson(json, JsonArray.class);
//            gson.fromJson(json, JsonObject.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
