package com.edu.zucc.controller;

import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Worker;
import com.edu.zucc.service.WorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@Api(value = "12技工接口", description = "技工管理")
@RestController
@RequestMapping("/api/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    /*根据员工名查*/
    @ApiOperation(value = "根据员工名查")
    @RequestMapping(value = "/findByWorkerName", method = RequestMethod.GET)
    public Object getByWorkerName(@RequestParam String workerName) {
        return workerService.findByWorkerName(workerName);
    }

    /*根据员工职位查*/
    @ApiOperation(value = "根据员工职位查")
    @RequestMapping(value = "/findByPosition", method = RequestMethod.GET)
    public Object getByPosition(@RequestParam String position) {
        return workerService.findByPosition(position);
    }

    /*根据员工日工资区间查*/
    @ApiOperation(value = "根据员工日工资区间查")
    @RequestMapping(value = "/findByDailyWage", method = RequestMethod.GET)
    public Object getByDailyWage(@RequestParam float first, @RequestParam float last) {
        return workerService.findByDailyWage(first, last);
    }


    @ApiOperation(value = "获得所有技工信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return workerService.findAll();
    }

    @ApiOperation(value = "根据id查询技工信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneById(@RequestParam int id) {
        return workerService.findById(id);
    }

    @ApiOperation(value = "新增技工信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody Worker worker) {
        return workerService.add(worker);
    }

    @ApiOperation(value = "删除技工信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Worker worker = new Worker();
        worker.setId(id);
        try {
            return workerService.delete(worker);
        } catch (DataIntegrityViolationException exception) {
            exception.printStackTrace();
            return EButil.Err("该记录存在子记录，不能删除");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return EButil.Err(throwable.getMessage());
        }
    }

    @ApiOperation(value = "修改技工信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Object modify(@RequestBody Worker worker) {
        return workerService.update(worker);
    }

}
