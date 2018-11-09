package com.shopping.dev.repository;

import com.shopping.dev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author:毕胜朋
 * @date:2018/11/8 8:47
 */

public interface RegisterRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
