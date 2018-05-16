package com.edu.zucc.controller;

import com.edu.zucc.SecutityConfig;
import com.edu.zucc.model.Furniture;
import com.edu.zucc.model.MessageInfo;
import com.edu.zucc.model.Messageboard;
import com.edu.zucc.model.User;
import com.edu.zucc.service.MessageboardService;
import com.edu.zucc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(value = "09留言板接口", description = "留言板管理")
@RestController
@RequestMapping("/api/messageboard")
public class MessageboardController {
    @Autowired
    private MessageboardService messageboardService;
    @Autowired
    private UserService userService;

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

    @ApiOperation(value = "新增留言板信息")
    @RequestMapping(value = "/addnouser", method = RequestMethod.POST)
    public Object createWithoutUser(@RequestBody Messageboard messageboard, HttpSession session) {
        String name=session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User user=userService.findByUsername(name);
        messageboard.setUser(user.getId());
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
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Object modify(@RequestBody Messageboard messageboard) {
        return messageboardService.update(messageboard);
    }

    @ApiOperation(value = "输出所有留言的标准信息")
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAllMessage() {
        List<Messageboard> messageboards = messageboardService.findAll();
        List<MessageInfo> messageInfos=new ArrayList<>();
        if (messageboards != null) {
            List<User> users = userService.findAll();
            Map<Integer, String> mapUsers = users.stream().collect(
                    Collectors.toMap(User::getId, User::getUsername));
           for (Messageboard messageboard:messageboards){
                int b=messageboard.getUser();
                messageInfos.add(new MessageInfo(messageboard,mapUsers.get(b)));
            }
        }
        return messageInfos;
    }
}
