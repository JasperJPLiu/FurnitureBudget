package com.edu.zucc.mapper;

import com.edu.zucc.model.Productbudget;

import java.util.List;

public interface ProductbudgetMapper {
    int add(Productbudget productbudget);

    int delete(Productbudget productbudget);

    int update(Productbudget productbudget);

    List<Productbudget> findAll();

    Productbudget findByKey(Productbudget productbudget);

    Productbudget findByUserAndFurniture(Productbudget productbudget);

    /*根据用户查*/
    List<Productbudget> findByUser(Productbudget productbudget);
}
