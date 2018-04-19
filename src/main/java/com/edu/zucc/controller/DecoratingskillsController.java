package com.edu.zucc.controller;

import com.edu.zucc.model.Decoratingskills;
import com.edu.zucc.service.DecoratingskillsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "02装潢技巧接口", description = "装潢技巧管理")
@RestController
@RequestMapping("/api/decoratingskills")
public class DecoratingskillsController {
    @Autowired
    private DecoratingskillsService decoratingskillsService;

    @ApiOperation(value = "获得所有装潢技巧")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return decoratingskillsService.findAll();
    }

    @ApiOperation(value = "根据标题查询装潢技巧")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getByTitle(@RequestParam String title) {
        return decoratingskillsService.findByTitle(title);
    }

    @ApiOperation(value = "新增装潢技巧")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestParam String title, @RequestParam String content) {
        Decoratingskills decoratingskills = new Decoratingskills();
        decoratingskills.setTitle(title);
        decoratingskills.setContent(content);
        return decoratingskillsService.add(decoratingskills);
    }

    @ApiOperation(value = "删除装潢技巧")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Decoratingskills decoratingskills = new Decoratingskills();
        decoratingskills.setId(id);
        return decoratingskillsService.delete(decoratingskills);
    }

    @ApiOperation(value = "修改装潢技巧")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object modify(@RequestBody Decoratingskills decoratingskills) {
        return decoratingskillsService.update(decoratingskills);
    }

}
