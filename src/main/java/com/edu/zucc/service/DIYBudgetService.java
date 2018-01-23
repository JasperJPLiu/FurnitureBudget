package com.edu.zucc.service;

import com.edu.zucc.mapper.DIYBudgetMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.DIYBudget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DIYBudgetService {
    private DIYBudgetMapper dIYBudgetMapper;

    @Autowired
    public DIYBudgetService(DIYBudgetMapper dIYBudgetMapper) {
        this.dIYBudgetMapper = dIYBudgetMapper;
    }

    /*根据用户查*/
    public List<DIYBudget> findByUser(int user) {
        DIYBudget dIYBudget = new DIYBudget();
        dIYBudget.setUser(user);
        return dIYBudgetMapper.findByUser(dIYBudget);
    }

    public DIYBudget findById(int id) {
        DIYBudget dIYBudget = new DIYBudget();
        dIYBudget.setId(id);
        return dIYBudgetMapper.findByKey(dIYBudget);
    }

    public List<DIYBudget> findAll() {
        return dIYBudgetMapper.findAll();
    }

    public EButil add(DIYBudget dIYBudget) {
        EButil result = new EButil();
        dIYBudgetMapper.add(dIYBudget);
        result.Success();
        return result;
    }

    public EButil delete(DIYBudget dIYBudget) {
        EButil result = new EButil();
        if (findById(dIYBudget.getId()) == null) {
            result.Error("DIYBudget is not existed");
            return result;
        }
        dIYBudgetMapper.delete(dIYBudget);
        result.Success();
        return result;
    }

    public EButil update(DIYBudget dIYBudget) {
        EButil result = new EButil();
        if (findById(dIYBudget.getId()) == null) {
            result.Error("DIYBudget is not existed");
            return result;
        }
        dIYBudgetMapper.update(dIYBudget);
        result.Success();
        return result;
    }

}
