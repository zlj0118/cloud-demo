package com.shopping.dev.usermessage.controller;

import com.shopping.dev.entity.UserMessage;
import com.shopping.dev.usermessage.FileUtil.UploadFile;
import com.shopping.dev.usermessage.service.UserMessageService;

import com.shopping.dev.usermessage.util.JwtUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;


@RestController
@RequestMapping("/userMessage")
public class UserMessageController {


    @Resource
    private UserMessageService userMessageService;

    // 更改个人信息
    @RequestMapping("/addMessage")
    @ResponseBody
    public UserMessage add(UserMessage userMessage, @Param("birthday") String birthday,
                           HttpServletRequest request) throws Exception {

        String token = request.getHeader("Authentication");
        Long userId = JwtUtils.getUserId(token);
        System.out.println(userId);
        userMessage.setUid(userId);
        if (birthday != null) {
            userMessage.setBirthday(Date.valueOf(birthday));
        }
        userMessageService.addUseMessage(userMessage);
        return userMessageService.findByUid(userMessage.getUid());
    }

    // 上传头像
    @RequestMapping("/upFile")
    @ResponseBody
    public UserMessage upFile(UserMessage userMessage, HttpServletRequest request,
                              @RequestParam(value = "image") MultipartFile image) throws Exception {

        String token = request.getHeader("Authentication");
        Long userId = JwtUtils.getUserId(token);
        userMessage.setUid(userId);
        String[] strings = UploadFile.uploadFile(image);
        String Path = "http://35.220.246.127:8080/" + strings[0] + "/" + strings[1];
        userMessage.setImagePath(Path);
        userMessageService.addUseMessage(userMessage);
        return find(request);
    }

    @RequestMapping("/upFile2")
    public UserMessage upFile2(@RequestParam("imagePath") String imagePath, HttpServletRequest request, UserMessage userMessage) throws Exception {
        String token = request.getHeader("Authentication");
        System.out.println(token + "=====");
        Long userId = JwtUtils.getUserId(token);
        System.out.println(userId);
        userMessage.setUid(userId);
        userMessage.setImagePath(imagePath);
        userMessageService.addUseMessage(userMessage);
        return find(request);
    }


    // 查看用户信息
    @RequestMapping("/findByUid")
    @ResponseBody
    public UserMessage find(HttpServletRequest request) {
        String token = request.getHeader("Authentication");
        System.out.println(token);
        Long userId = JwtUtils.getUserId(token);
        return userMessageService.findByUid(userId);
    }
}
