package com.edu.zucc.controller;

import com.edu.zucc.model.Furnituretype;
import com.edu.zucc.service.FurnituretypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "06家具类型接口", description = "家具类型管理")
@RestController
@RequestMapping("/api/furnituretype")
public class FurnituretypeController {
    @Autowired
    private FurnituretypeService furnituretypeService;

    @ApiOperation(value = "获得所有家具类型信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return furnituretypeService.findAll();
    }

    @ApiOperation(value = "根据id查询家具类型信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneById(@RequestParam int id) {
        return furnituretypeService.findById(id);
    }

    @ApiOperation(value = "新增家具类型信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody Furnituretype furnituretype) {
        return furnituretypeService.add(furnituretype);
    }

    @ApiOperation(value = "删除家具类型信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Furnituretype furnituretype = new Furnituretype();
        furnituretype.setId(id);
        return furnituretypeService.delete(furnituretype);
    }

    @ApiOperation(value = "修改家具类型信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object modify(@RequestBody Furnituretype furnituretype) {
        return furnituretypeService.update(furnituretype);
    }

}
