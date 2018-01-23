package com.edu.zucc.controller;

import com.edu.zucc.model.Productbudget;
import com.edu.zucc.service.ProductbudgetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "10成品预算接口", description = "成品预算管理")
@RestController
@RequestMapping("/api/productbudget")
public class ProductbudgetController {
    @Autowired
    private ProductbudgetService productbudgetService;

    /*根据用户查*/
    @ApiOperation(value = "根据用户查")
    @RequestMapping(value = "/findByUser", method = RequestMethod.GET)
    public Object findByUser(@RequestParam int user) {
        return productbudgetService.findByUser(user);
    }


    @ApiOperation(value = "获得所有成品预算信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return productbudgetService.findAll();
    }

    @ApiOperation(value = "根据id查询成品预算信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneById(@RequestParam int id) {
        return productbudgetService.findById(id);
    }

    @ApiOperation(value = "新增成品预算信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody Productbudget productbudget) {
        return productbudgetService.add(productbudget);
    }

    @ApiOperation(value = "删除成品预算信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Productbudget productbudget = new Productbudget();
        productbudget.setId(id);
        return productbudgetService.delete(productbudget);
    }

    @ApiOperation(value = "修改成品预算信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object modify(@RequestBody Productbudget productbudget) {
        return productbudgetService.update(productbudget);
    }

}
