package com.edu.zucc.controller;

import com.edu.zucc.model.Messageboard;
import com.edu.zucc.service.MessageboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "09留言板接口", description = "留言板管理")
@RestController
@RequestMapping("/api/messageboard")
public class MessageboardController {
    @Autowired
    private MessageboardService messageboardService;

    /*根据标题查*/
    @ApiOperation(value = "根据标题查")
    @RequestMapping(value = "/findByTitle", method = RequestMethod.GET)
    public Object findByTitle(@RequestParam String title) {
        return messageboardService.findByTitle(title);
    }

    /*根据发布用户查*/
    @ApiOperation(value = "根据发布用户查")
    @RequestMapping(value = "/findByUser", method = RequestMethod.GET)
    public Object findByUser(@RequestParam int user) {
        return messageboardService.findByUser(user);
    }


    @ApiOperation(value = "获得所有留言板信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return messageboardService.findAll();
    }

    @ApiOperation(value = "根据id查询留言板信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneById(@RequestParam int id) {
        return messageboardService.findById(id);
    }

    @ApiOperation(value = "新增留言板信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody Messageboard messageboard) {
        return messageboardService.add(messageboard);
    }

    @ApiOperation(value = "删除留言板信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Messageboard messageboard = new Messageboard();
        messageboard.setId(id);
        return messageboardService.delete(messageboard);
    }

    @ApiOperation(value = "修改留言板信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object modify(@RequestBody Messageboard messageboard) {
        return messageboardService.update(messageboard);
    }

}
