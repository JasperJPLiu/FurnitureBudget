package com.edu.zucc.mapper;

import com.edu.zucc.model.Decoratingskills;

import java.util.List;


public interface DecoratingskillsMapper {
    int add(Decoratingskills decoratingskills);

    int delete(Decoratingskills decoratingskills);

    int update(Decoratingskills decoratingskills);

    List<Decoratingskills> findAll();

    Decoratingskills findByKey(Decoratingskills decoratingskills);

    List<Decoratingskills> findByTitle(Decoratingskills decoratingskills);
}
