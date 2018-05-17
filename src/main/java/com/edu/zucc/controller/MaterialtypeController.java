package com.edu.zucc.controller;

import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Materialtype;
import com.edu.zucc.service.MaterialtypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@Api(value = "08材质类型接口", description = "材质类型管理")
@RestController
@RequestMapping("/api/materialtype")
public class MaterialtypeController {
    @Autowired
    private MaterialtypeService materialtypeService;

    @ApiOperation(value = "获得所有材质类型信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return materialtypeService.findAll();
    }

    @ApiOperation(value = "根据id查询材质类型信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneById(@RequestParam int id) {
        return materialtypeService.findById(id);
    }

    @ApiOperation(value = "新增材质类型信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody Materialtype materialtype) {
        return materialtypeService.add(materialtype);
    }

    @ApiOperation(value = "删除材质类型信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Materialtype materialtype = new Materialtype();
        materialtype.setId(id);
        try {
            return materialtypeService.delete(materialtype);
        } catch (DataIntegrityViolationException exception) {
            exception.printStackTrace();
            return EButil.Err("该记录存在子记录，不能删除");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return EButil.Err(throwable.getMessage());
        }
    }

    @ApiOperation(value = "修改材质类型信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Object modify(@RequestBody Materialtype materialtype) {
        return materialtypeService.update(materialtype);
    }

}
