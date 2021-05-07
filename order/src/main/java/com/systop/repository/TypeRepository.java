package com.systop.repository;

import com.systop.entity.Type;

import java.util.List;

public interface TypeRepository {
    public TypeRepository findById(long id);
    public List<Type> findTypes();
}
