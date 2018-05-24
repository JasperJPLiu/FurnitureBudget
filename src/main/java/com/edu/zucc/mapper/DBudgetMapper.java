package com.edu.zucc.mapper;

import com.edu.zucc.model.DBudget;

import java.util.List;

public interface DBudgetMapper {
    int add(DBudget dBudget);

    int delete(DBudget dBudget);

    int update(DBudget dBudget);

    List<DBudget> findAll();

    DBudget findByKey(DBudget dBudget);
}
