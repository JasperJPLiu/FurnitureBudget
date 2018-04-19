package com.edu.zucc.controller;

import com.edu.zucc.model.*;
import com.edu.zucc.service.DIYBudgetService;
import com.edu.zucc.service.MaterialService;
import com.edu.zucc.service.UserService;
import com.edu.zucc.service.WorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(value = "03DIY预算接口", description = "DIY预算管理")
@RestController
@RequestMapping("/api/dIYBudget")
public class DIYBudgetController {
    @Autowired
    private DIYBudgetService dIYBudgetService;
    @Autowired
    private UserService userService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private WorkerService workerService;


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

    @ApiOperation(value = "输出所有预算的标准信息")
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAllDIYBudget() {
        List<DIYBudget> diyBudgets = dIYBudgetService.findAll();
        List<DIYInfo> diyInfos=new ArrayList<>();
        if (diyBudgets != null) {
            List<User> users = userService.findAll();
            List<Worker> workers = workerService.findAll();
            List<Material> materials=materialService.findAll();
            Map<Integer, String> mapUsers = users.stream().collect(
                    Collectors.toMap(User::getId, User::getUsername));
            Map<Integer, String> mapWorkers = workers.stream().collect(
                    Collectors.toMap(Worker::getId, Worker::getWorkerName));
            Map<Integer, Float> mapWage = workers.stream().collect(
                    Collectors.toMap(Worker::getId, Worker::getDailyWage));
            Map<Integer, String> mapMaterials = materials.stream().collect(
                    Collectors.toMap(Material::getId, Material::getMaterialName));
             Map<Integer, Float> mapPrices = materials.stream().collect(
                    Collectors.toMap(Material::getId, Material::getUnitPrice));
            for (DIYBudget diy:diyBudgets){
                int u=diy.getUser();
                String worker_ids=diy.getWorkers();
                String material_ids=diy.getMeterials();
                String[] Workers=worker_ids.split(",");
                String[] Materials=material_ids.split(",");
                String w=new String();
                String m=new String();
                float price=0;
                for(int i=0;i<Workers.length;i++){
                    String[] wd=Workers[i].split("-");
                    int wid=Integer.parseInt(wd[0]);
                    float wday=Float.parseFloat(wd[1]);
                    float p=wday*mapWage.get(wid);
                    w+=mapWorkers.get(wid);
                    w+="("+wday+",￥"+p+")";
                    price+=p;
                    if (i!=Workers.length-1)
                        w+=",";
                }
                for(int i=0;i<Materials.length;i++){
                    String[] md=Materials[i].split("-");
                    int mid=Integer.parseInt(md[0]);
                    float mper=Float.parseFloat(md[1]);
                    float p=mper*mapPrices.get(mid);
                    m+=mapMaterials.get(mid);
                    m+="("+mid+",￥"+p+")";
                    price+=p;
                    if (i!=Materials.length-1)
                        m+=",";
                }
                diyInfos.add(new DIYInfo(diy,mapUsers.get(u),w,m,price));
            }
        }
        return diyInfos;
    }
}
