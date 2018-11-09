package com.shopping.dev.repository;

import com.shopping.dev.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

/**
 * @author:毕胜朋
 * @date:2018/11/7 17:56
 */
public interface LoginRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
