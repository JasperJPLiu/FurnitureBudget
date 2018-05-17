package com.edu.zucc.mapper;

import com.edu.zucc.model.Brand;

import java.util.List;


public interface BrandMapper {
    int add(Brand brand);

    int delete(Brand brand) throws Throwable;

    int update(Brand brand);

    List<Brand> findAll();

    Brand findByKey(Brand brand);

    List<Brand> findByBrandName(Brand brand);
}
