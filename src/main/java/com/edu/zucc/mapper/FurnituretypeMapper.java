package com.edu.zucc.mapper;

import com.edu.zucc.model.Furnituretype;

import java.util.List;


public interface FurnituretypeMapper {
    int add(Furnituretype furnituretype);

    int delete(Furnituretype furnituretype);

    int update(Furnituretype furnituretype);

    List<Furnituretype> findAll();

    Furnituretype findByKey(Furnituretype furnituretype);
}
