package com.edu.zucc.service;

import com.edu.zucc.mapper.FurnitureMapper;
import com.edu.zucc.model.Brand;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Furniture;
import com.edu.zucc.model.Furnituretype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FurnitureService {
    private FurnitureMapper furnitureMapper;

    @Autowired
    public FurnitureService(FurnitureMapper furnitureMapper) {
        this.furnitureMapper = furnitureMapper;
    }

    /*根据家具类型查*/
    public List<Furniture> findByType(String typeName) {
        Furnituretype furnituretype = new Furnituretype();
        furnituretype.setTypeName(typeName);
        return furnitureMapper.findByType(furnituretype);
    }

    /*根据家具类型查*/
    public List<Furniture> findByType(int id) {
        Furniture furniture=new Furniture();
        furniture.setFurnitureType(id);
        return furnitureMapper.findByTypeID(furniture);
    }

    /*根据家具名称查*/
    public List<Furniture> findByName(String furnitureName) {
        Furniture furniture = new Furniture();
        furniture.setFurnitureName(furnitureName);
        return furnitureMapper.findByName(furniture);
    }

    /*根据品牌名查*/
    public List<Furniture> findByBand(String brandName) {
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        return furnitureMapper.findByBand(brand);
    }

    /*根据品牌ID查*/
    public List<Furniture> findByBand(int id) {
        Furniture furniture=new Furniture();
        furniture.setBrand(id);
        return furnitureMapper.findByBandID(furniture);
    }

    /*根据价格区间查*/
    public List<Furniture> findByPrice(float first, float last) {
        Furniture furniture = new Furniture();
        furniture.setFirst(first);
        furniture.setLast(last);
        return furnitureMapper.findByPrice(furniture);
    }


    public Furniture findById(int id) {
        Furniture furniture = new Furniture();
        furniture.setId(id);
        return furnitureMapper.findByKey(furniture);
    }

    public List<Furniture> findAll() {
        return furnitureMapper.findAll();
    }

    public EButil add(Furniture furniture) {
        EButil result = new EButil();
        furnitureMapper.add(furniture);
        result.Success();
        return result;
    }

    public EButil delete(Furniture furniture) throws Throwable{
        EButil result = new EButil();
        if (findById(furniture.getId()) == null) {
            result.Error("Furniture is not existed");
            return result;
        }
        furnitureMapper.delete(furniture);
        result.Success();
        return result;
    }

    public EButil update(Furniture furniture) {
        EButil result = new EButil();
        if (findById(furniture.getId()) == null) {
            result.Error("Furniture is not existed");
            return result;
        }
        furnitureMapper.update(furniture);
        result.Success();
        return result;
    }

}
