package com.edu.zucc.mapper;

import com.edu.zucc.model.Worker;

import java.util.List;

public interface WorkerMapper {
    int add(Worker worker);

    int delete(Worker worker);

    int update(Worker worker);

    List<Worker> findAll();

    Worker findByKey(Worker worker);

    List<Worker> findByWorkerName(Worker worker);

    List<Worker> findByPosition(Worker worker);

    List<Worker> findByDailyWage(Worker worker);
}
