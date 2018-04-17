package com.edu.zucc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liujiapeng on 2018/1/4.
 */
@Controller
@RequestMapping("/")
public class Webcontroller {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "starter";
    }

    @RequestMapping("/BrandManager")
    public String toMBrand() {
        return "brandmanager";
    }

    @RequestMapping("/BudgetManager")
    public String toMBudget() {
        return "budgetmanager";
    }

    @RequestMapping("/FurnitureManager")
    public String toMFurniture() {
        return "furnmanager";
    }

    @RequestMapping("/KnowManager")
    public String toMKnow() {
        return "knowmanager";
    }

    @RequestMapping("/MaterialManager")
    public String toMMaterial() {
        return "matmanager";
    }

    @RequestMapping("/MessageManager")
    public String toMMessage() {
        return "messmanger";
    }

    @RequestMapping("/MaterialTypeManager")
    public String toMMType() {
        return "mtypemanager";
    }

    @RequestMapping("/ProductManager")
    public String toMProduct() {
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
