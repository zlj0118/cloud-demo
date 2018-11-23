package com.shopping.dev.service;

import com.shopping.dev.entity.Item;
import com.shopping.dev.entity.Order;
import com.shopping.dev.entity.OrderItem;
import com.shopping.dev.entity.OrderShipping;
import com.shopping.dev.param.CreateOrder;
import com.shopping.dev.param.ItemDel;
import com.shopping.dev.param.ItemParam;
import com.shopping.dev.param.OrderItemParam;
import com.shopping.dev.repository.ItemRepository;
import com.shopping.dev.repository.OrderItemRepository;
import com.shopping.dev.repository.OrderRepository;
import com.shopping.dev.repository.OrderShippingRepository;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

//import com.shopping.dev.repository.ItemRepository;


/**
 * 创建 JYQ  on  2018/11/8,15:50
 */
@Service
public class CartServiceImpl implements CartService {
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private ItemRepository repository;
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private OrderShippingRepository orderShippingRepository;
    @Resource
    private OrderItemRepository orderItemRepository;


    @Override
    public Object buy(ItemParam itemParam) {
        HashOperations hash = this.redisTemplate.opsForHash();
//        Jedis jedis = new Jedis();
        Long userId = itemParam.getUserId();
        Integer itemNum = itemParam.getItemNum();
        Long itemId = itemParam.getItemId();
        if (hash.hasKey("user:" + userId, "itemId:" + itemId)) {
            hash.increment("user:" + userId, "itemId:" + itemId, itemNum);
        } else {
            hash.put("user:" + userId, "itemId:" + itemId, itemNum.toString());
        }
//        if (jedis.hexists("user:" + userId, "itemId:" + itemId)) {
//            jedis.hincrBy("user:" + userId, "itemId:" + itemId, itemNum);
//        } else {
//            jedis.hset("user:" + userId, "itemId:" + itemId, itemNum.toString());
//        }
//        jedis.close();
        return null;

    }

    @Override
    public List<?> showCart(Long userId) {
//        Jedis jedis = new Jedis();
        HashOperations hash = this.redisTemplate.opsForHash();
        List<Map<String, Object>> list = new ArrayList<>();
        Set keys = hash.keys("user:" + userId);
//        Set<String> hkeys = jedis.hkeys("user:" + userId);
        for (Object key : keys) {
            Map<String, Object> map = new HashMap<>();
            String string = key.toString();
            Long substring = Long.parseLong(string.substring(string.indexOf(":", 1) + 1, string.length()));
            Item item = this.repository.findById(substring).get();
            map.put("item", item);
            Object o = hash.get("user:" + userId, "itemId:" + substring);
            String num = o.toString();
            map.put("itemNum", num);
            list.add(map);
        }
//        for (String hkey : hkeys) {
//            Map<String, Object> map = new HashMap<>();
//            Long substring = Long.parseLong(hkey.substring(hkey.indexOf(":", 1) + 1, hkey.length()));
//            Item item = this.repository.findById(substring).get();
//            map.put("item", item);
//            String num = jedis.hget("user:" + userId, "itemId:" + substring);
//            map.put("itemNum", num);
//            list.add(map);
//        }
//        jedis.close();
        return list;
    }

    @Override
    public String setTotal(Integer itemNum, Long itemId) {
//        Jedis jedis = new Jedis();
        HashOperations hash = this.redisTemplate.opsForHash();
        //  TODO   获取token中 userId
        hash.put("user:23", "itemId:" + itemId, itemNum.toString());
//        jedis.hset("user:23", "itemId:" + itemId, itemNum.toString());
//        jedis.close();
        return "数量设置";
    }

    @Override
    public Long delete(ItemParam itemParam) {
//        Jedis jedis = new Jedis();
        HashOperations hash = this.redisTemplate.opsForHash();
        Long userId = itemParam.getUserId();
        Long itemId = itemParam.getItemId();
        System.out.println("删除");
        Long hdel = hash.delete("user:" + userId, "itemId:" + itemId);
//        Long hdel = jedis.hdel("user:" + userId, "itemId:" + itemId);
        System.out.println("???????????????????");
//        jedis.close();
        return hdel;
    }

    @Override
    public void deleteChecked(String list) {
//        Jedis jedis = new Jedis();
        HashOperations hash = this.redisTemplate.opsForHash();
        String[] strings = list.split(",");
        for (String itemId : strings) {
//            jedis.hdel("user:" + 23, "itemId:" + Integer.parseInt(itemId));
            hash.delete("user:" + 23, "itemId:" + Integer.parseInt(itemId));

        }
//        jedis.close();
    }

    @Override
    public Item goodContent(Long itemId) {
        Item item = this.repository.findByItemId(itemId);
        return item;
    }

    @Override
    public List<?> commitOrder(String itemIdList) {
//        Jedis jedis = new Jedis();
        HashOperations hash = this.redisTemplate.opsForHash();
        List<Map<String, Object>> list = new ArrayList<>();
        String[] strings = itemIdList.split(",");
        for (String itemId : strings) {
            Map<String, Object> map = new HashMap<>();
            Item item = this.repository.findById(Long.parseLong(itemId)).get();
            map.put("item", item);
            Object o = hash.get("user:" + 23, "itemId:" + Integer.parseInt(itemId));
            String itemNum = o.toString();
//            String itemNum = jedis.hget("user:" + 23, "itemId:" + Integer.parseInt(itemId));
            map.put("itemNum", itemNum);
            list.add(map);
        }
        return list;
    }

    @Override
    public void createOrder(CreateOrder createOrder) {
//        createOrder.setUserId();
        String orderId = UUID.randomUUID().toString().replace("-", "");
        createOrder.setOrderId(orderId);
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(23L);
        order.setPaymentType(1L);
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.orderRepository.save(order);
        OrderShipping orderShipping = new OrderShipping();
        orderShipping.setOrderId(orderId);
        orderShipping.setReceiverName(createOrder.getReceiverName());
        orderShipping.setReceiverMobile(createOrder.getReceiverMobile());
        orderShipping.setReceiverAddress(createOrder.getReceiverAddress());
        this.orderShippingRepository.save(orderShipping);
        List<OrderItemParam> orderItemParamList = createOrder.getOrderItemParamList();
        Long totalPrice = 0L;
        for (OrderItemParam orderItemParam : orderItemParamList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setTitle(orderItemParam.getTitle());
            orderItem.setNum(orderItemParam.getItemNum());
            orderItem.setPicPath(orderItemParam.getImage());
            orderItem.setItemId(orderItemParam.getItemId());
            orderItem.setPrice(Long.parseLong(orderItemParam.getPrice()));
            Long itemNum = Long.parseLong(orderItemParam.getItemNum());
            Long price = Long.parseLong(orderItemParam.getPrice());
            totalPrice += itemNum * price;
            orderItem.setTotalFee(totalPrice);
            this.orderItemRepository.save(orderItem);
        }


    }


}