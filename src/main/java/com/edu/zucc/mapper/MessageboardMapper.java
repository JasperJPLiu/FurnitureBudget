package com.edu.zucc.mapper;

import com.edu.zucc.model.Messageboard;

import java.util.List;

public interface MessageboardMapper {
    int add(Messageboard messageboard);

    int delete(Messageboard messageboard);

    int update(Messageboard messageboard);

    List<Messageboard> findAll();

    Messageboard findByKey(Messageboard messageboard);

    /*根据标题查*/
    List<Messageboard> findByTitle(Messageboard messageboard);

    /*根据发布用户查*/
    List<Messageboard> findByUser(Messageboard messageboard);
}
