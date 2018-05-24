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

    /*根据用户查*/
    public List<DBudget> findByUser(int user) {
        DBudget dBudget = new DBudget();
        dBudget.setUser(user);
        return dBudgetMapper.findByUser(dBudget);
    }

    public List<DBudget> findAll() {
        return dBudgetMapper.findAll();
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

    public DBudget findById(int user) {
        DBudget dBudget = new DBudget();
        dBudget.setUser(user);
        return dBudgetMapper.findByKey(dBudget);
    }

}
