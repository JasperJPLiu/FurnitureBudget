package com.edu.zucc.mapper;

import com.edu.zucc.model.Material;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface MaterialMapper {
    int add(Material material);

    int delete(Material material);

    int update(Material material);

    List<Material> findAll();

    List<Material> findByKey(Material material);
}
