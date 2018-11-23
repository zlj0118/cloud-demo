package com.shopping.dev.usermessage.service;

import com.shopping.dev.entity.UserMessage;

public interface UserMessageService {

    Integer addUseMessage(UserMessage userMessage);

    UserMessage findByUid(Long uid);
}
