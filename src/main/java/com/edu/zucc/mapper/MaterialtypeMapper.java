package com.edu.zucc.mapper;

import com.edu.zucc.model.Materialtype;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface MaterialtypeMapper {
    int add(Materialtype materialtype);

    int delete(Materialtype materialtype);

    int update(Materialtype materialtype);

    List<Materialtype> findAll();

    List<Materialtype> findByKey(Materialtype materialtype);
}
