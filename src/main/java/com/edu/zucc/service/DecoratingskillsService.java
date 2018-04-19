package com.edu.zucc.service;

import com.edu.zucc.mapper.DecoratingskillsMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Decoratingskills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DecoratingskillsService {
    private DecoratingskillsMapper decoratingskillsMapper;

    @Autowired
    public DecoratingskillsService(DecoratingskillsMapper decoratingskillsMapper) {
        this.decoratingskillsMapper = decoratingskillsMapper;
    }

    public List<Decoratingskills> findByTitle(String title) {
        Decoratingskills decoratingskills = new Decoratingskills();
        decoratingskills.setTitle(title);
        return decoratingskillsMapper.findByTitle(decoratingskills);
    }

    public Decoratingskills findById(int id) {
        Decoratingskills decoratingskills = new Decoratingskills();
        decoratingskills.setId(id);
        return decoratingskillsMapper.findByKey(decoratingskills);
    }

    public List<Decoratingskills> findAll() {
        return decoratingskillsMapper.findAll();
    }

    public EButil add(Decoratingskills decoratingskills) {
        EButil result = new EButil();
        decoratingskillsMapper.add(decoratingskills);
        result.Success();
        return result;
    }

    public EButil delete(Decoratingskills decoratingskills) {
        EButil result = new EButil();
        if (findById(decoratingskills.getId()) == null) {
            result.Error("The Article is not existed");
            return result;
        }
        decoratingskillsMapper.delete(decoratingskills);
        result.Success();
        return result;
    }

    public EButil update(Decoratingskills decoratingskills) {
        EButil result = new EButil();
        if (findById(decoratingskills.getId()) == null) {
            result.Error("The Article is not existed");
            return result;
        }
        decoratingskillsMapper.update(decoratingskills);
        result.Success();
        return result;
    }

}
