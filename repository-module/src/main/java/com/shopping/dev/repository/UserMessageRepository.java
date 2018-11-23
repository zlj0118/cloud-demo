package com.shopping.dev.repository;

import com.shopping.dev.entity.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

    UserMessage findByUid(Long uid);

    @Modifying
    @Transactional
    @Query(value = "update UserMessage um set " +
            "um.nickName = CASE WHEN :#{#userMessage.nickName} IS NULL THEN um.nickName ELSE :#{#userMessage.nickName} END ," +
            "um.gender = CASE WHEN :#{#userMessage.gender} IS NULL THEN um.gender ELSE :#{#userMessage.gender} END ," +
            "um.birthday = CASE WHEN :#{#userMessage.birthday} IS NULL THEN um.birthday ELSE :#{#userMessage.birthday} END ," +
            "um.hobbies = CASE WHEN :#{#userMessage.hobbies} IS NULL THEN um.hobbies ELSE :#{#userMessage.hobbies} END ," +
            "um.email = CASE WHEN :#{#userMessage.email} IS NULL THEN um.email ELSE :#{#userMessage.email} END ," +
            "um.realName = CASE WHEN :#{#userMessage.realName} IS NULL THEN um.realName ELSE :#{#userMessage.realName} END ," +
            "um.address = CASE WHEN :#{#userMessage.address} IS NULL THEN um.address ELSE :#{#userMessage.address} END ," +
            "um.imagePath = CASE WHEN :#{#userMessage.imagePath} IS NULL THEN um.imagePath ELSE :#{#userMessage.imagePath} END ," +
            "um.marriage = CASE WHEN :#{#userMessage.marriage} IS NULL THEN um.marriage ELSE :#{#userMessage.marriage} END ," +
            "um.income = CASE WHEN :#{#userMessage.income} IS NULL THEN um.income ELSE :#{#userMessage.income} END ," +
            "um.idCard = CASE WHEN :#{#userMessage.idCard} IS NULL THEN um.idCard ELSE :#{#userMessage.idCard} END ," +
            "um.teach = CASE WHEN :#{#userMessage.teach} IS NULL THEN um.teach ELSE :#{#userMessage.teach} END ," +
            "um.industry = CASE WHEN :#{#userMessage.industry} IS NULL THEN um.industry ELSE :#{#userMessage.industry} END  " +
            "where um.uid = :#{#userMessage.uid}")
    Integer update(@Param("userMessage") UserMessage userMessage);
}
