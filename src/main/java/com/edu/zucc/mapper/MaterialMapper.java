package com.edu.zucc.mapper;

import com.edu.zucc.model.Brand;
import com.edu.zucc.model.Material;
import com.edu.zucc.model.Materialtype;

import java.util.List;

public interface MaterialMapper {
    int add(Material material);

    int delete(Material material) throws Throwable;

    int update(Material material);

    List<Material> findAll();

    Material findByKey(Material material);

    /*根据材质类型名查*/
    List<Material> findByType(Materialtype materialtype);

    /*根据材质名称查*/
    List<Material> findByName(Material material);

    /*根据品牌名查*/
    List<Material> findByBand(Brand brand);

    /*根据价格区间查*/
    List<Material> findByPrice(Material material);
}
