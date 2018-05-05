package com.edu.zucc.mapper;

import com.edu.zucc.model.Brand;
import com.edu.zucc.model.Furniture;
import com.edu.zucc.model.Furnituretype;

import java.util.List;

public interface FurnitureMapper {
    int add(Furniture furniture);

    int delete(Furniture furniture);

    int update(Furniture furniture);

    List<Furniture> findAll();

    Furniture findByKey(Furniture furniture);

    /*根据家具类型名查*/
    List<Furniture> findByType(Furnituretype furnituretype);

    /*根据家具类型ID查*/
    List<Furniture> findByTypeID(Furniture furniture);

    /*根据家具名称查*/
    List<Furniture> findByName(Furniture furniture);

    /*根据品牌名查*/
    List<Furniture> findByBand(Brand brand);

    /*根据品牌ID查*/
    List<Furniture> findByBandID(Furniture furniture);

    /*根据价格区间查*/
    List<Furniture> findByPrice(Furniture furniture);

}
