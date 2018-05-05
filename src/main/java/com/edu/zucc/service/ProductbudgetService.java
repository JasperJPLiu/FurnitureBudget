package com.edu.zucc.service;

import com.edu.zucc.mapper.ProductbudgetMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Productbudget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductbudgetService {
    private ProductbudgetMapper productbudgetMapper;

    @Autowired
    public ProductbudgetService(ProductbudgetMapper productbudgetMapper) {
        this.productbudgetMapper = productbudgetMapper;
    }

    /*根据用户查*/
    public List<Productbudget> findByUser(int user) {
        Productbudget productbudget = new Productbudget();
        productbudget.setUser(user);
        return productbudgetMapper.findByUser(productbudget);
    }

    public Productbudget findByUserAndFurniture(int user,int furniture) {
        Productbudget productbudget = new Productbudget();
        productbudget.setUser(user);
        productbudget.setFurnitures(furniture);
        return productbudgetMapper.findByUserAndFurniture(productbudget);
    }


    public Productbudget findById(int id) {
        Productbudget productbudget = new Productbudget();
        productbudget.setId(id);
        return productbudgetMapper.findByKey(productbudget);
    }

    public List<Productbudget> findAll() {
        return productbudgetMapper.findAll();
    }

    public EButil add(Productbudget productbudget) {
        EButil result = new EButil();
        Productbudget productbudget1=findByUserAndFurniture(productbudget.getUser(),productbudget.getFurnitures());
        if (productbudget1!=null){
            result.Error("此相同的收藏记录已存在");
            return result;
        }
        productbudgetMapper.add(productbudget);
        result.Success();
        return result;
    }

    public EButil delete(Productbudget productbudget) {
        EButil result = new EButil();
        if (findById(productbudget.getId()) == null) {
            result.Error("Productbudget is not existed");
            return result;
        }
        productbudgetMapper.delete(productbudget);
        result.Success();
        return result;
    }

    public EButil update(Productbudget productbudget) {
        EButil result = new EButil();
        if (findById(productbudget.getId()) == null) {
            result.Error("Productbudget is not existed");
            return result;
        }
        productbudgetMapper.update(productbudget);
        result.Success();
        return result;
    }

}
