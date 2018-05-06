package com.edu.zucc;

import com.edu.zucc.controller.BrandController;
import com.edu.zucc.model.*;
import com.edu.zucc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String toMBrand(HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        return "brandmanager";
    }

    @RequestMapping("/BudgetManager")
    public String toMBudget(Model model, HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        List<User> users = userService.findAll();
        List<Material> materials = materialService.findAll();
        List<Worker> workers = workerService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("materials", materials);
        model.addAttribute("workers", workers);
        return "budgetmanager";
    }

    @RequestMapping("/FurnitureManager")
    public String toMFurniture(Model model, HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        List<Brand> brands = brandService.findAll();
        List<Furnituretype> furnituretypes = furnituretypeService.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("types", furnituretypes);
        return "furnmanager";
    }

    @RequestMapping("/KnowManager")
    public String toMKnow(HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        return "knowmanager";
    }

    @RequestMapping("/MaterialManager")
    public String toMMaterial(Model model, HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        List<Brand> brands = brandService.findAll();
        List<Materialtype> materialtypes = materialtypeService.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("types", materialtypes);
        return "matmanager";
    }

    @RequestMapping("/MessageManager")
    public String toMMessage(Model model, HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "messmanger";
    }

    @RequestMapping("/MaterialTypeManager")
    public String toMMType(HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        return "mtypemanager";
    }

    @RequestMapping("/ProductManager")
    public String toMProduct(Model model, HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        List<User> users = userService.findAll();
        List<Furniture> furnitures = furnitureService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("furnitures", furnitures);
        return "productmanager";
    }

    @RequestMapping("/SkillManager")
    public String toMSkill(HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        return "skillmanager";
    }

    @RequestMapping("/TypeManager")
    public String toMType(HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        return "typemanager";
    }

    @RequestMapping("/UserManager")
    public String toMUser(HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        return "usermanager";
    }

    @RequestMapping("/WorkerManager")
    public String toMWorker(HttpSession session) {
        String unme = session.getAttribute(SecutityConfig.SESSION_KEY_USER).toString();
        User uSer = userService.findByUsername(unme);
        if (uSer.getUserType().equals("normal"))
            return "redirect:/index";
        return "workermanager";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> login(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        EButil ebUtil = new EButil();
        try {
            ebUtil = userService.Login(user);
        } catch (Throwable throwable) {
            ebUtil.Error(throwable.getMessage());
        }
        map.put("message", ebUtil.getMessage());
        map.put("result", ebUtil.getResultCode());
        if (ebUtil.getResultCode() != 0)
            return map;

        session.setAttribute(SecutityConfig.SESSION_KEY_USER, username);
        return map;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute(SecutityConfig.SESSION_KEY_USER);
        return "redirect:/";
    }
}
