package com.edu.zucc.controller;

import com.edu.zucc.model.DBudget;
import com.edu.zucc.service.DBudgetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "13装修预算接口", description = "装修预算管理")
@RestController
@RequestMapping("/api/dBudget")
public class DBudgetController {
    @Autowired
    private DBudgetService dBudgetService;

    @ApiOperation(value = "新增信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody DBudget dBudget) {
        return dBudgetService.add(dBudget);
    }

    @ApiOperation(value = "删除信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        DBudget dBudget = new DBudget();
        dBudget.setId(id);
        return dBudgetService.delete(dBudget);
    }

    @ApiOperation(value = "修改信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Object modify(@RequestBody DBudget dBudget) {
        return dBudgetService.update(dBudget);
    }

    @ApiOperation(value = "获得所有信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return dBudgetService.findAll();
    }

    @ApiOperation(value = "根据id查询信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneById(@RequestParam int id) {
        return dBudgetService.findById(id);
    }

    @ApiOperation(value = "查询所需费用")
    @RequestMapping(value = "/getfee", method = RequestMethod.POST)
    public Object getFee(@RequestParam int city, @RequestParam int htype,  @RequestParam  double harea, @RequestParam int room, @RequestParam int hall, @RequestParam int kitchen, @RequestParam int toilet, @RequestParam int balcony) {
        dBudgetService.setTheta();
        return dBudgetService.getFee(city, htype, harea, room, hall, kitchen, toilet, balcony);
    }
}
