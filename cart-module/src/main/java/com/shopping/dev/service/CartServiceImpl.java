package com.shopping.dev.service;

import com.shopping.dev.entity.Item;
import com.shopping.dev.param.ItemDel;
import com.shopping.dev.param.ItemParam;
import com.shopping.dev.repository.ItemRepository;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.*;

//import com.shopping.dev.repository.ItemRepository;


/**
 * 创建 JYQ  on  2018/11/8,15:50
 */
@Service
public class CartServiceImpl implements CartService {

    @Resource
    private ItemRepository repository;



    @Override
    public Object buy(ItemParam itemParam) {
//        JedisPool pool = new JedisPool();
//        Jedis jedis = pool.getResource();
        Jedis jedis = new Jedis();
        Long userId = itemParam.getUserId();
        Integer itemNum = itemParam.getItemNum();
        Long itemId = itemParam.getItemId();
        if(jedis.hexists("user:" + userId, "itemId:"+itemId)){
            jedis.hincrBy("user:" + userId, "itemId:"+itemId, itemNum);
        }else
        {
            jedis.hset("user:" + userId, "itemId:" + itemId, itemNum.toString());
        }
        jedis.close();
       return null;

    }
    @Override
    public List<?> showCart(Long userId) {
//        JedisPool pool = new JedisPool();
//        Jedis jedis = pool.getResource();
        Jedis jedis = new Jedis();
        List<Map<String ,Object>>  list = new ArrayList<>();
        Set<String> hkeys = jedis.hkeys("user:" + userId);
        for (String hkey : hkeys) {
            Map<String,Object>  map= new HashMap<>();
            Long substring =Long.parseLong(hkey.substring(hkey.indexOf(":", 1) + 1, hkey.length()));
            Item item = this.repository.findById(substring).get();
            map.put("item",item);
            String num = jedis.hget("user:" + userId, "itemId:" + substring);
            map.put("itemNum",num);
            list.add(map);
        }
        jedis.close();
        return list;
    }

    @Override
    public String setTotal(Integer itemNum, Long itemId) {
//        JedisPool pool = new JedisPool();
//        Jedis jedis = pool.getResource();
        Jedis jedis = new Jedis();
        //  TODO   获取token中 userId
        jedis.hset("user:23" , "itemId:" + itemId, itemNum.toString());
        jedis.close();
        return "数量设置";
    }

   @Override
    public Long delete(ItemParam itemParam) {
//        JedisPool pool = new JedisPool();
//        Jedis jedis = pool.getResource();
        Jedis jedis = new Jedis();
        Long userId = itemParam.getUserId();
        Long itemId = itemParam.getItemId();
        System.out.println("删除");
        Long hdel = jedis.hdel("user:" + userId, "itemId:" + itemId);
        System.out.println("???????????????????");
        jedis.close();
        return  hdel;
    }

    @Override
    public void deleteChecked(String list) {
        Jedis jedis = new Jedis();
        String[] strings = list.split(",");
        for (String itemId : strings) {
            jedis.hdel("user:" + 23, "itemId:" + Integer.parseInt(itemId));
        }
        jedis.close();
    }


}