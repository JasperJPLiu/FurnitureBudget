package com.edu.zucc.service;

import com.edu.zucc.mapper.WorkerMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkerService {
    private WorkerMapper workerMapper;

    @Autowired
    public WorkerService(WorkerMapper workerMapper) {
        this.workerMapper = workerMapper;
    }

    /*根据员工名查*/
    public List<Worker> findByWorkerName(String workerName) {
        Worker worker = new Worker();
        worker.setWorkerName(workerName);
        return workerMapper.findByWorkerName(worker);
    }

    /*根据员工职位查*/
    public List<Worker> findByPosition(String position) {
        Worker worker = new Worker();
        worker.setPosition(position);
        return workerMapper.findByPosition(worker);
    }

    /**
     * 根据员工日工资区间查
     * @param first
     * @param last
     * @return
     */
    public List<Worker> findByDailyWage(float first, float last) {
        Worker worker = new Worker();
        worker.setFirst(first);
        worker.setLast(last);
        return workerMapper.findByDailyWage(worker);
    }

    public Worker findById(int id) {
        Worker worker = new Worker();
        worker.setId(id);
        return workerMapper.findByKey(worker);
    }

    public List<Worker> findAll() {
        return workerMapper.findAll();
    }

    public EButil add(Worker worker) {
        EButil result = new EButil();
        workerMapper.add(worker);
        result.Success();
        return result;
    }

    public EButil delete(Worker worker) {
        EButil result = new EButil();
        if (findById(worker.getId()) == null) {
            result.Error("Worker is not existed");
            return result;
        }
        workerMapper.delete(worker);
        result.Success();
        return result;
    }

    public EButil update(Worker worker) {
        EButil result = new EButil();
        if (findById(worker.getId()) == null) {
            result.Error("Worker is not existed");
            return result;
        }
        workerMapper.update(worker);
        result.Success();
        return result;
    }

}
