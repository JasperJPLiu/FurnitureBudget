package com.edu.zucc.mapper;

import com.edu.zucc.model.Productbudget;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface ProductbudgetMapper {
    int add(Productbudget productbudget);

    int delete(Productbudget productbudget);

    int update(Productbudget productbudget);

    List<Productbudget> findAll();

    List<Productbudget> findByKey(Productbudget productbudget);
}
