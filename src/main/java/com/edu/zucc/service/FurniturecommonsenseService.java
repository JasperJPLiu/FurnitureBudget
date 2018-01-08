package com.edu.zucc.service;

import com.edu.zucc.mapper.FurniturecommonsenseMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Furniturecommonsense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/3.
 */
@Service
public class FurniturecommonsenseService {
    private FurniturecommonsenseMapper furniturecommonsenseMapper;

    @Autowired
    public FurniturecommonsenseService(FurniturecommonsenseMapper furniturecommonsenseMapper) {
        this.furniturecommonsenseMapper = furniturecommonsenseMapper;
    }

    public Furniturecommonsense findByTitle(String title) {
        Furniturecommonsense furniturecommonsense = new Furniturecommonsense();
        furniturecommonsense.setTitle(title);
        return furniturecommonsenseMapper.findByTitle(furniturecommonsense);
    }

    public Furniturecommonsense findById(int id) {
        Furniturecommonsense furniturecommonsense = new Furniturecommonsense();
        furniturecommonsense.setId(id);
        return furniturecommonsenseMapper.findByKey(furniturecommonsense);
    }

    public List<Furniturecommonsense> findAll() {
        return furniturecommonsenseMapper.findAll();
    }

    public EButil add(Furniturecommonsense furniturecommonsense) {
        EButil result = new EButil();
        furniturecommonsenseMapper.add(furniturecommonsense);
        result.Success();
        return result;
    }

    public EButil delete(Furniturecommonsense furniturecommonsense) {
        EButil result = new EButil();
        if (findById(furniturecommonsense.getId()) == null) {
            result.Error("Article is not existed");
            return result;
        }
        furniturecommonsenseMapper.delete(furniturecommonsense);
        result.Success();
        return result;
    }

    public EButil update(Furniturecommonsense furniturecommonsense) {
        EButil result = new EButil();
        if (findById(furniturecommonsense.getId()) == null) {
            result.Error("Article is not existed");
            return result;
        }
        furniturecommonsenseMapper.update(furniturecommonsense);
        result.Success();
        return result;
    }

}
