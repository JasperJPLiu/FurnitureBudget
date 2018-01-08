package com.edu.zucc.mapper;

import com.edu.zucc.model.Messageboard;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface MessageboardMapper {
    int add(Messageboard messageboard);

    int delete(Messageboard messageboard);

    int update(Messageboard messageboard);

    List<Messageboard> findAll();

    List<Messageboard> findByKey(Messageboard messageboard);
}
