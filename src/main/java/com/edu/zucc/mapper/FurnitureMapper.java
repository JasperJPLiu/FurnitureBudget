package com.edu.zucc.mapper;

import com.edu.zucc.model.Furniture;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface FurnitureMapper {
    int add(Furniture furniture);

    int delete(Furniture furniture);

    int update(Furniture furniture);

    List<Furniture> findAll();

    List<Furniture> findByKey(Furniture furniture);
}
