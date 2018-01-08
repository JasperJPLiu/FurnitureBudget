package com.edu.zucc.mapper;

import com.edu.zucc.model.Worker;

import java.util.List;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public interface WorkerMapper {
    int add(Worker worker);

    int delete(Worker worker);

    int update(Worker worker);

    List<Worker> findAll();

    List<Worker> findByKey(Worker worker);
}
