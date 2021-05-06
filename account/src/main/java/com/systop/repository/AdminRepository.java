package com.systop.repository;

import com.systop.entity.Admin;

public interface AdminRepository {
    public Admin login(String username,String password);
}
