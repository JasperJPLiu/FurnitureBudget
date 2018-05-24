package com.edu.zucc.mapper;

import com.edu.zucc.model.DBudget;

import java.util.List;

public interface DBudgetMapper {
    int add(DBudget dBudget);

    int delete(DBudget dBudget);

    List<DBudget> findAll();

    /*根据用户查*/
    List<DBudget> findByUser(DBudget dBudget);

    DBudget findByKey(DBudget dBudget);
}
