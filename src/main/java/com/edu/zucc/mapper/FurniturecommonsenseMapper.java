package com.edu.zucc.mapper;

import com.edu.zucc.model.Furniturecommonsense;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface FurniturecommonsenseMapper {
    int add(Furniturecommonsense furniturecommonsense);

    int delete(Furniturecommonsense furniturecommonsense);

    int update(Furniturecommonsense furniturecommonsense);

    List<Furniturecommonsense> findAll();

    Furniturecommonsense findByKey(Furniturecommonsense furniturecommonsense);

    Furniturecommonsense findByTitle(Furniturecommonsense furniturecommonsense);
}
