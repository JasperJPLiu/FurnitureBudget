package com.edu.zucc.service;

import com.edu.zucc.mapper.FurnituretypeMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Furnituretype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FurnituretypeService {
    private FurnituretypeMapper furnituretypeMapper;

    @Autowired
    public FurnituretypeService(FurnituretypeMapper furnituretypeMapper) {
        this.furnituretypeMapper = furnituretypeMapper;
    }

    public Furnituretype findById(int id) {
        Furnituretype furnituretype = new Furnituretype();
        furnituretype.setId(id);
        return furnituretypeMapper.findByKey(furnituretype);
    }

    public List<Furnituretype> findAll() {
        return furnituretypeMapper.findAll();
    }

    public EButil add(Furnituretype furnituretype) {
        EButil result = new EButil();
        furnituretypeMapper.add(furnituretype);
        result.Success();
        return result;
    }

    public EButil delete(Furnituretype furnituretype) {
        EButil result = new EButil();
        if (findById(furnituretype.getId()) == null) {
            result.Error("Furnituretype is not existed");
            return result;
        }
        furnituretypeMapper.delete(furnituretype);
        result.Success();
        return result;
    }

    public EButil update(Furnituretype furnituretype) {
        EButil result = new EButil();
        if (findById(furnituretype.getId()) == null) {
            result.Error("Furnituretype is not existed");
            return result;
        }
        furnituretypeMapper.update(furnituretype);
        result.Success();
        return result;
    }

}
