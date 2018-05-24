package com.edu.zucc.controller;

import com.edu.zucc.SecutityConfig;
import com.edu.zucc.model.DBudgetInfo;
import com.edu.zucc.model.DBudget;
import com.edu.zucc.model.User;
import com.edu.zucc.service.DBudgetService;
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

@Api(value = "13装修预算接口", description = "装修预算管理")
@RestController
@RequestMapping("/api/dBudget")
public class DBudgetController {
    @Autowired
    private DBudgetService dBudgetService;
    @Autowired
    private UserService userService;

    /*根据用户查*/
    @ApiOperation(value = "根据用户查")
    @RequestMapping(value = "/findByUser", method = RequestMethod.GET)
    public Object findByUser(@RequestParam int user) {
        return dBudgetService.findByUser(user);
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

    @ApiOperation(value = "新增信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody DBudget dBudget) {
        return dBudgetService.add(dBudget);
    }

    @ApiOperation(value = "新增信息")
    @RequestMapping(value = "/addnouser", method = RequestMethod.POST)
    public Object createWithoutUser(@RequestBody DBudget dBudget, HttpSession session) {
        String name=session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User user=userService.findByUsername(name);
        dBudget.setUser(user.getId());
        return dBudgetService.add(dBudget);
    }

    @ApiOperation(value = "删除信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        DBudget dBudget = new DBudget();
        dBudget.setId(id);
        return dBudgetService.delete(dBudget);
    }

    @ApiOperation(value = "输出所有标准信息")
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAllDBudget() {
        List<DBudget> dBudgets = dBudgetService.findAll();
        List<DBudget> dBudgetInfos=new ArrayList<>();
        if (dBudgets != null) {
            List<User> users = userService.findAll();
            Map<Integer, String> mapUsers = users.stream().collect(
                    Collectors.toMap(User::getId, User::getUsername));
            for (DBudget dBudget:dBudgets){
                int b=dBudget.getUser();
                dBudgetInfos.add(new DBudgetInfo(dBudget,mapUsers.get(b)));
            }
        }
        return dBudgetInfos;
    }
}
