package com.edu.zucc.service;

import com.edu.zucc.mapper.BrandMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandService {
    private BrandMapper brandMapper;

    @Autowired
    public BrandService(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    public List<Brand> findByBrandName(String branName) {
        Brand brand = new Brand();
        brand.setBrandName(branName);
        return brandMapper.findByBrandName(brand);
    }

    public Brand findById(int id) {
        Brand brand = new Brand();
        brand.setId(id);
        return brandMapper.findByKey(brand);
    }

    public List<Brand> findAll() {
        return brandMapper.findAll();
    }

    public EButil add(Brand brand) {
        EButil result = new EButil();
        brandMapper.add(brand);
        result.Success();
        return result;
    }

    public EButil delete(Brand brand) throws Throwable{
        EButil result = new EButil();
        if (findById(brand.getId()) == null) {
            result.Error("Brand is not existed");
            return result;
        }
        brandMapper.delete(brand);
        result.Success();
        return result;
    }

    public EButil update(Brand brand) {
        EButil result = new EButil();
        if (findById(brand.getId()) == null) {
            result.Error("Brand is not existed");
            return result;
        }
        brandMapper.update(brand);
        result.Success();
        return result;
    }

}
