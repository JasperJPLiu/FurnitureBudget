package com.edu.zucc.service;

import com.edu.zucc.mapper.MaterialtypeMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Materialtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaterialtypeService {
    private MaterialtypeMapper materialtypeMapper;

    @Autowired
    public MaterialtypeService(MaterialtypeMapper materialtypeMapper) {
        this.materialtypeMapper = materialtypeMapper;
    }

    public Materialtype findById(int id) {
        Materialtype materialtype = new Materialtype();
        materialtype.setId(id);
        return materialtypeMapper.findByKey(materialtype);
    }

    public List<Materialtype> findAll() {
        return materialtypeMapper.findAll();
    }

    public EButil add(Materialtype materialtype) {
        EButil result = new EButil();
        materialtypeMapper.add(materialtype);
        result.Success();
        return result;
    }

    public EButil delete(Materialtype materialtype) throws Throwable{
        EButil result = new EButil();
        if (findById(materialtype.getId()) == null) {
            result.Error("Materialtype is not existed");
            return result;
        }
        materialtypeMapper.delete(materialtype);
        result.Success();
        return result;
    }

    public EButil update(Materialtype materialtype) {
        EButil result = new EButil();
        if (findById(materialtype.getId()) == null) {
            result.Error("Materialtype is not existed");
            return result;
        }
        materialtypeMapper.update(materialtype);
        result.Success();
        return result;
    }

}
