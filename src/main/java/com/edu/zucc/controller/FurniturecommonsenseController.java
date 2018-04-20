package com.edu.zucc.controller;

import com.edu.zucc.model.Furniturecommonsense;
import com.edu.zucc.service.FurniturecommonsenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "04家具常识接口", description = "家具常识管理")
@RestController
@RequestMapping("/api/furniturecommonsense")
public class FurniturecommonsenseController {
    @Autowired
    private FurniturecommonsenseService furniturecommonsenseService;

    @ApiOperation(value = "获得所有家具常识")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return furniturecommonsenseService.findAll();
    }

    @ApiOperation(value = "根据标题查询家具常识")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getByTitle(@RequestParam String title) {
        return furniturecommonsenseService.findByTitle(title);
    }

    @ApiOperation(value = "新增家具常识")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestParam String title, @RequestParam String content) {
        Furniturecommonsense furniturecommonsense = new Furniturecommonsense();
        furniturecommonsense.setTitle(title);
        furniturecommonsense.setContent(content);
        return furniturecommonsenseService.add(furniturecommonsense);
    }

    @ApiOperation(value = "删除家具常识")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Furniturecommonsense furniturecommonsense = new Furniturecommonsense();
        furniturecommonsense.setId(id);
        return furniturecommonsenseService.delete(furniturecommonsense);
    }

    @ApiOperation(value = "修改家具常识")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Object modify(@RequestBody Furniturecommonsense furniturecommonsense) {
        return furniturecommonsenseService.update(furniturecommonsense);
    }

}
