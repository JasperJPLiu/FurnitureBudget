package com.edu.zucc.controller;

import com.edu.zucc.model.Brand;
import com.edu.zucc.model.Material;
import com.edu.zucc.model.MaterialInfo;
import com.edu.zucc.model.Materialtype;
import com.edu.zucc.service.BrandService;
import com.edu.zucc.service.ListToMap;
import com.edu.zucc.service.MaterialService;
import com.edu.zucc.service.MaterialtypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(value = "07材质接口", description = "材质管理")
@RestController
@RequestMapping("/api/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private MaterialtypeService materialtypeService;


    /*根据材质类型名查*/
    @ApiOperation(value = "根据材质类型名查")
    @RequestMapping(value = "/findByType", method = RequestMethod.GET)
    public Object findByType(@RequestParam String typeName) {
        return materialService.findByType(typeName);
    }

    /*根据材质名称查*/
    @ApiOperation(value = "根据材质名称查")
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public Object findByName(@RequestParam String furnitureName) {
        return materialService.findByName(furnitureName);
    }

    /*根据品牌名查*/
    @ApiOperation(value = "根据品牌名查")
    @RequestMapping(value = "/findByBand", method = RequestMethod.GET)
    public Object findByBand(@RequestParam String brandName) {
        return materialService.findByBand(brandName);
    }

    /*根据价格区间查*/
    @ApiOperation(value = "根据价格区间查")
    @RequestMapping(value = "/findByPrice", method = RequestMethod.GET)
    public Object findByPrice(@RequestParam float first, @RequestParam float last) {
        return materialService.findByPrice(first, last);
    }

    @ApiOperation(value = "获得所有材质信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return materialService.findAll();
    }

    @ApiOperation(value = "根据id查询材质信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneById(@RequestParam int id) {
        return materialService.findById(id);
    }

    @ApiOperation(value = "新增材质信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody Material material) {
        return materialService.add(material);
    }

    @ApiOperation(value = "删除材质信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Material material = new Material();
        material.setId(id);
        return materialService.delete(material);
    }

    @ApiOperation(value = "修改材质信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object modify(@RequestBody Material material) {
        return materialService.update(material);
    }


    @ApiOperation(value = "输出所有材料的标准信息")
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAllMaterials() {
        List<Material> materials = materialService.findAll();
        List<MaterialInfo> materialInfos=new ArrayList<>();
        if (materials != null) {
            List<Brand> brands = brandService.findAll();
            List<Materialtype> materialtypes = materialtypeService.findAll();
            Map<Integer, String> mapBrands = brands.stream().collect(
                    Collectors.toMap(Brand::getId, Brand::getBrandName));
            Map<Integer, String> mapTypes = materialtypes.stream().collect(
                    Collectors.toMap(Materialtype::getId, Materialtype::getTypeName));
            for (Material material:materials){
                int b=material.getBrand();
                int t=material.getMaterialType();
                materialInfos.add(new MaterialInfo(material,mapBrands.get(b),mapTypes.get(t)));
            }
        }
        return materialInfos;
    }

}
