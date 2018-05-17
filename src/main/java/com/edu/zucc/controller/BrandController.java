package com.edu.zucc.controller;

import com.edu.zucc.model.Brand;
import com.edu.zucc.model.EButil;
import com.edu.zucc.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "01品牌接口", description = "品牌管理")
@RestController
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "获得所有品牌信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        List<Brand> brands = brandService.findAll();
        return brands;
    }

    @ApiOperation(value = "根据品牌名查询品牌信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneByBrandName(@RequestParam String brandName) {
        return brandService.findByBrandName(brandName);
    }

    @ApiOperation(value = "新增品牌")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody Brand brand) {
        return brandService.add(brand);
    }

    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Brand brand = new Brand();
        brand.setId(id);
        try {
            return brandService.delete(brand);
        }catch (DataIntegrityViolationException exception){
            exception.printStackTrace();
            return EButil.Err("该记录存在子记录，不能删除");
        } catch (Throwable throwable) {
           throwable.printStackTrace();
           return EButil.Err(throwable.getMessage());
        }
    }

    @ApiOperation(value = "修改品牌信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Object modify(@RequestBody Brand brand) {
        return brandService.update(brand);
    }

}
