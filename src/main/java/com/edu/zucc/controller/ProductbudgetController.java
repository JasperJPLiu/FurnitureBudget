package com.edu.zucc.controller;

import com.edu.zucc.SecutityConfig;
import com.edu.zucc.model.Furniture;
import com.edu.zucc.model.ProductInfo;
import com.edu.zucc.model.Productbudget;
import com.edu.zucc.model.User;
import com.edu.zucc.service.FurnitureService;
import com.edu.zucc.service.ProductbudgetService;
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

@Api(value = "10成品预算接口", description = "成品预算管理")
@RestController
@RequestMapping("/api/productbudget")
public class ProductbudgetController {
    @Autowired
    private ProductbudgetService productbudgetService;
    @Autowired
    private UserService userService;
    @Autowired
    private FurnitureService furnitureService;


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
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Object modify(@RequestBody Productbudget productbudget) {
        return productbudgetService.update(productbudget);
    }

    @ApiOperation(value = "输出所有成品预算的标准信息")
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAllProductBudget() {
        List<Productbudget> product_budgets = productbudgetService.findAll();
        List<ProductInfo> productInfos = new ArrayList<>();
        if (product_budgets != null) {
            List<User> users = userService.findAll();
            List<Furniture> furnitures = furnitureService.findAll();
            Map<Integer, String> mapUsers = users.stream().collect(
                    Collectors.toMap(User::getId, User::getUsername));
            Map<Integer, String> mapFurnitures = furnitures.stream().collect(
                    Collectors.toMap(Furniture::getId, Furniture::getFurnitureName));
            for (Productbudget productbudget : product_budgets) {
                int b = productbudget.getUser();
                int t = productbudget.getFurnitures();
                productInfos.add(new ProductInfo(productbudget, mapUsers.get(b), mapFurnitures.get(t)));
            }
        }
        return productInfos;
    }

    @ApiOperation(value = "根据用户查询成品预算的标准信息")
    @RequestMapping(value = "/getallbyuser", method = RequestMethod.GET)
    public Object getAllProductBudgetByUser(HttpSession session) {
        String username=session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User user=userService.findByUsername(username);
        if (user==null)
            return "no such user";
        List<Productbudget> product_budgets = productbudgetService.findByUser(user.getId());
        List<ProductInfo> productInfos = new ArrayList<>();
        if (product_budgets != null) {
            List<User> users = userService.findAll();
            List<Furniture> furnitures = furnitureService.findAll();
            Map<Integer, String> mapUsers = users.stream().collect(
                    Collectors.toMap(User::getId, User::getUsername));
            Map<Integer, String> mapFurnitures = furnitures.stream().collect(
                    Collectors.toMap(Furniture::getId, Furniture::getFurnitureName));
            Map<Integer, Float> mapPrice = furnitures.stream().collect(
                    Collectors.toMap(Furniture::getId, Furniture::getUnitPrice));
            for (Productbudget productbudget : product_budgets) {
                int b = productbudget.getUser();
                int t = productbudget.getFurnitures();
                productInfos.add(new ProductInfo(productbudget, mapUsers.get(b), mapFurnitures.get(t),mapPrice.get(t)));
            }
        }
        return productInfos;
    }

    @ApiOperation(value = "用户新增成品预算信息")
    @RequestMapping(value = "/addwithuser", method = RequestMethod.POST)
    public Object create(@RequestParam int id,HttpSession session) {
        Productbudget productbudget=new Productbudget();
        productbudget.setFurnitures(id);
        User user=userService.findByUsername(session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString());
        productbudget.setUser(user.getId());
        return productbudgetService.add(productbudget);
    }
}
