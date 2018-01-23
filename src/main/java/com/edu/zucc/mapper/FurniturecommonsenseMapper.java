package com.edu.zucc.mapper;

import com.edu.zucc.model.Furniturecommonsense;

import java.util.List;


public interface FurniturecommonsenseMapper {
    int add(Furniturecommonsense furniturecommonsense);

    int delete(Furniturecommonsense furniturecommonsense);

    int update(Furniturecommonsense furniturecommonsense);

    List<Furniturecommonsense> findAll();

    Furniturecommonsense findByKey(Furniturecommonsense furniturecommonsense);

    List<Furniturecommonsense> findByTitle(Furniturecommonsense furniturecommonsense);
}
