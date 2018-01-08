package com.edu.zucc.mapper;

import com.edu.zucc.model.Brand;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface BrandMapper {
    int add(Brand brand);

    int delete(Brand brand);

    int update(Brand brand);

    List<Brand> findAll();

    List<Brand> findByKey(Brand brand);
}
