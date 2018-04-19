package com.edu.zucc.mapper;

import com.edu.zucc.model.DIYBudget;

import java.util.List;


public interface DIYBudgetMapper {
    int add(DIYBudget diyBudget);

    int delete(DIYBudget diyBudget);

    int update(DIYBudget diyBudget);

    List<DIYBudget> findAll();

    DIYBudget findByKey(DIYBudget diyBudget);

    /*根据用户查*/
    List<DIYBudget> findByUser(DIYBudget diyBudget);
}
