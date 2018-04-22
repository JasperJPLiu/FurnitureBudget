package com.edu.zucc;

import com.edu.zucc.controller.BrandController;
import com.edu.zucc.model.*;
import com.edu.zucc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by moshenlin on 2018/1/4.
 */
@Controller
@RequestMapping("")
public class Webcontroller {

    @Autowired
    private BrandService brandService;
    @Autowired
    private MaterialtypeService materialtypeService;
    @Autowired
    private FurnituretypeService furnituretypeService;
    @Autowired
    private UserService userService;
    @Autowired
    private FurnitureService furnitureService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private MaterialService materialService;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String user() {
        return "user";
    }

    @RequestMapping("/skills")
    public String skill() {
        return "skill";
    }

    @RequestMapping("/knowledge")
    public String know() {
        return "know";
    }

    @RequestMapping("/product")
    public String product() {
        return "product";
    }

    @RequestMapping("/budget")
    public String budget() {
        return "budget";
    }

    @RequestMapping("/BrandManager")
    public String toMBrand() {
        return "brandmanager";
    }

    @RequestMapping("/BudgetManager")
    public String toMBudget(Model model) {
        List<User> users = userService.findAll();
        List<Material> materials = materialService.findAll();
        List<Worker> workers = workerService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("materials", materials);
        model.addAttribute("workers", workers);
        return "budgetmanager";
    }

    @RequestMapping("/FurnitureManager")
    public String toMFurniture(Model model) {
        List<Brand> brands = brandService.findAll();
        List<Furnituretype> furnituretypes = furnituretypeService.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("types", furnituretypes);
        return "furnmanager";
    }

    @RequestMapping("/KnowManager")
    public String toMKnow() {
        return "knowmanager";
    }

    @RequestMapping("/MaterialManager")
    public String toMMaterial(Model model) {
        List<Brand> brands = brandService.findAll();
        List<Materialtype> materialtypes = materialtypeService.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("types", materialtypes);
        return "matmanager";
    }

    @RequestMapping("/MessageManager")
    public String toMMessage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "messmanger";
    }

    @RequestMapping("/MaterialTypeManager")
    public String toMMType() {
        return "mtypemanager";
    }

    @RequestMapping("/ProductManager")
    public String toMProduct(Model model) {
        List<User> users = userService.findAll();
        List<Furniture> furnitures = furnitureService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("furnitures", furnitures);
        return "productmanager";
    }

    @RequestMapping("/SkillManager")
    public String toMSkill() {
        return "skillmanager";
    }

    @RequestMapping("/TypeManager")
    public String toMType() {
        return "typemanager";
    }

    @RequestMapping("/UserManager")
    public String toMUser() {
        return "usermanager";
    }

    @RequestMapping("/WorkerManager")
    public String toMWorker() {
        return "workermanager";
    }
}
