package com.edu.zucc.mapper;

import com.edu.zucc.model.Decoratingskills;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface DecoratingskillsMapper {
    int add(Decoratingskills decoratingskills);

    int delete(Decoratingskills decoratingskills);

    int update(Decoratingskills decoratingskills);

    List<Decoratingskills> findAll();

    List<Decoratingskills> findByKey(Decoratingskills decoratingskills);
}
