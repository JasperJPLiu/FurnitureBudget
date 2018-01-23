package com.edu.zucc.controller;

import com.edu.zucc.model.DIYBudget;
import com.edu.zucc.service.DIYBudgetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "03DIY预算接口", description = "DIY预算管理")
@RestController
@RequestMapping("/api/dIYBudget")
public class DIYBudgetController {
    @Autowired
    private DIYBudgetService dIYBudgetService;

    /*根据用户查*/
    @ApiOperation(value = "根据用户查")
    @RequestMapping(value = "/findByUser", method = RequestMethod.GET)
    public Object findByUser(@RequestParam int user) {
        return dIYBudgetService.findByUser(user);
    }


    @ApiOperation(value = "获得所有DIY预算信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return dIYBudgetService.findAll();
    }

    @ApiOperation(value = "根据id查询DIY预算信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneById(@RequestParam int id) {
        return dIYBudgetService.findById(id);
    }

    @ApiOperation(value = "新增DIY预算")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody DIYBudget dIYBudget) {
        return dIYBudgetService.add(dIYBudget);
    }

    @ApiOperation(value = "删除DIY预算")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        DIYBudget dIYBudget = new DIYBudget();
        dIYBudget.setId(id);
        return dIYBudgetService.delete(dIYBudget);
    }

    @ApiOperation(value = "修改DIY预算信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object modify(@RequestBody DIYBudget dIYBudget) {
        return dIYBudgetService.update(dIYBudget);
    }

}
