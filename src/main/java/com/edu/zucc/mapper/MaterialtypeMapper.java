package com.edu.zucc.mapper;

import com.edu.zucc.model.Materialtype;

import java.util.List;

public interface MaterialtypeMapper {
    int add(Materialtype materialtype);

    int delete(Materialtype materialtype);

    int update(Materialtype materialtype);

    List<Materialtype> findAll();

    Materialtype findByKey(Materialtype materialtype);
}
