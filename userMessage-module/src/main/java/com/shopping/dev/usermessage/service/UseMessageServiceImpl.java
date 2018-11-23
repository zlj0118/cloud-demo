package com.shopping.dev.usermessage.service;
import com.shopping.dev.entity.UserMessage;
import com.shopping.dev.repository.UserMessageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UseMessageServiceImpl implements UserMessageService {

    @Resource
    private UserMessageRepository repository;

    @Override
    public Integer addUseMessage(UserMessage userMessage) {
        System.out.println("=======");
        return this.repository.update(userMessage);
    }

    @Override
    public UserMessage findByUid(Long uid) {
        return repository.findByUid(uid);
    }
}
