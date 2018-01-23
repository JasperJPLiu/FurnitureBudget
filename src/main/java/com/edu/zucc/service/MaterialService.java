package com.edu.zucc.service;

import com.edu.zucc.mapper.MaterialMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Material;
import com.edu.zucc.model.Materialtype;
import com.edu.zucc.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaterialService {
    private MaterialMapper materialMapper;

    @Autowired
    public MaterialService(MaterialMapper materialMapper) {
        this.materialMapper = materialMapper;
    }

    /*根据材质类型查*/
    public List<Material> findByType(String typeName) {
        Materialtype materialtype = new Materialtype();
        materialtype.setTypeName(typeName);
        return materialMapper.findByType(materialtype);
    }

    /*根据材质名称查*/
    public List<Material> findByName(String materialName) {
        Material material = new Material();
        material.setMaterialName(materialName);
        return materialMapper.findByName(material);
    }

    /*根据品牌名查*/
    public List<Material> findByBand(String brandName) {
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        return materialMapper.findByBand(brand);
    }

    /*根据价格区间查*/
    public List<Material> findByPrice(float first, float last) {
        Material material = new Material();
        material.setFirst(first);
        material.setLast(last);
        return materialMapper.findByPrice(material);
    }


    public Material findById(int id) {
        Material material = new Material();
        material.setId(id);
        return materialMapper.findByKey(material);
    }

    public List<Material> findAll() {
        return materialMapper.findAll();
    }

    public EButil add(Material material) {
        EButil result = new EButil();
        materialMapper.add(material);
        result.Success();
        return result;
    }

    public EButil delete(Material material) {
        EButil result = new EButil();
        if (findById(material.getId()) == null) {
            result.Error("Material is not existed");
            return result;
        }
        materialMapper.delete(material);
        result.Success();
        return result;
    }

    public EButil update(Material material) {
        EButil result = new EButil();
        if (findById(material.getId()) == null) {
            result.Error("Material is not existed");
            return result;
        }
        materialMapper.update(material);
        result.Success();
        return result;
    }

}
