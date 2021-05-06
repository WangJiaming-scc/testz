package com.systop.repository;

import com.systop.entity.Admin;
import com.systop.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
