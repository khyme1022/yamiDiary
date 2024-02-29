package com.yamidiary.yamiyami.user.repository;

import com.yamidiary.yamiyami.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User getByEmail(String email);
}
