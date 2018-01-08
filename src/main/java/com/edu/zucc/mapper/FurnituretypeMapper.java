package com.edu.zucc.mapper;

import com.edu.zucc.model.Furnituretype;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface FurnituretypeMapper {
    int add(Furnituretype furnituretype);

    int delete(Furnituretype furnituretype);

    int update(Furnituretype furnituretype);

    List<Furnituretype> findAll();

    List<Furnituretype> findByKey(Furnituretype furnituretype);
}
