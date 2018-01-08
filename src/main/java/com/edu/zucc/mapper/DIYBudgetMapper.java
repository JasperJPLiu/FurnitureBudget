package com.edu.zucc.mapper;

import com.edu.zucc.model.DIYBudget;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface DIYBudgetMapper {
    int add(DIYBudget diyBudget);

    int delete(DIYBudget diyBudget);

    int update(DIYBudget diyBudget);

    List<DIYBudget> findAll();

    List<DIYBudget> findByKey(DIYBudget diyBudget);
}
