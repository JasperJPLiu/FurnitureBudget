package com.edu.zucc.service;

import com.edu.zucc.mapper.DBudgetMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.DBudget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBudgetService {
    private DBudgetMapper dBudgetMapper;

    @Autowired
    public DBudgetService(DBudgetMapper dBudgetMapper) {
        this.dBudgetMapper = dBudgetMapper;
    }

    public EButil add(DBudget dBudget) {
        EButil result = new EButil();
        dBudgetMapper.add(dBudget);
        result.Success();
        return result;
    }

    public EButil delete(DBudget dBudget) {
        EButil result = new EButil();
        if (findById(dBudget.getId()) == null) {
            result.Error("Messageboard is not existed");
            return result;
        }
        dBudgetMapper.delete(dBudget);
        result.Success();
        return result;
    }

    public EButil update(DBudget dBudget) {
        EButil result = new EButil();
        if (findById(dBudget.getId()) == null) {
            result.Error("DBudget is not existed");
            return result;
        }
        dBudgetMapper.update(dBudget);
        result.Success();
        return result;
    }

    public List<DBudget> findAll() {
        return dBudgetMapper.findAll();
    }

    public DBudget findById(int id) {
        DBudget dBudget = new DBudget();
        dBudget.setId(id);
        return dBudgetMapper.findByKey(dBudget);
    }

}
