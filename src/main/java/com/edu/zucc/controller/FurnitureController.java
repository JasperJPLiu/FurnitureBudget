package com.edu.zucc.controller;

import com.edu.zucc.model.*;
import com.edu.zucc.service.BrandService;
import com.edu.zucc.service.FurnitureService;
import com.edu.zucc.service.FurnituretypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(value = "05家具接口", description = "家具管理")
@RestController
@RequestMapping("/api/furniture")
public class FurnitureController {
    @Autowired
    private FurnitureService furnitureService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private FurnituretypeService furnituretypeService;


    /*根据家具类型名查*/
     @ApiOperation(value = "根据家具类型名查")
     @RequestMapping(value = "/findByType", method = RequestMethod.GET)
     public Object findByType(@RequestParam String typeName) {
         return furnitureService.findByType(typeName);
     }

    /*根据家具名称查*/
    @ApiOperation(value = "根据家具名称查")
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public Object findByName(@RequestParam String furnitureName) {
        return furnitureService.findByName(furnitureName);
    }

    /*根据品牌名查*/
    @ApiOperation(value = "根据品牌名查")
    @RequestMapping(value = "/findByBand", method = RequestMethod.GET)
    public Object findByBand(@RequestParam String brandName) {
        return furnitureService.findByBand(brandName);
    }

    /*根据价格区间查*/
    @ApiOperation(value = "根据价格区间查")
    @RequestMapping(value = "/findByPrice", method = RequestMethod.GET)
    public Object findByPrice(@RequestParam float first, @RequestParam float last) {
        return furnitureService.findByPrice(first,last);
    }


    @ApiOperation(value = "获得所有家具信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAll() {
        return furnitureService.findAll();
    }

    @ApiOperation(value = "根据id查询家具信息")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneById(@RequestParam int id) {
        return furnitureService.findById(id);
    }

    @ApiOperation(value = "新增家具信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object create(@RequestBody Furniture furniture) {
        return furnitureService.add(furniture);
    }

    @ApiOperation(value = "删除家具信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable int id) {
        Furniture furniture = new Furniture();
        furniture.setId(id);
        return furnitureService.delete(furniture);
    }

    @ApiOperation(value = "修改家具信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object modify(@RequestBody Furniture furniture) {
        return furnitureService.update(furniture);
    }


    @ApiOperation(value = "输出所有家具的标准信息")
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object getAllFuniture() {
        List<Furniture> furnitures = furnitureService.findAll();
        List<FurnitureInfo> furnitureInfos=new ArrayList<>();
        if (furnitures != null) {
            List<Brand> brands = brandService.findAll();
            List<Furnituretype> furnituretypes = furnituretypeService.findAll();
            Map<Integer, String> mapBrands = brands.stream().collect(
                    Collectors.toMap(Brand::getId, Brand::getBrandName));
            Map<Integer, String> mapTypes = furnituretypes.stream().collect(
                    Collectors.toMap(Furnituretype::getId, Furnituretype::getTypeName));
            for (Furniture furniture:furnitures){
                int b=furniture.getBrand();
                int t=furniture.getFurnitureType();
                furnitureInfos.add(new FurnitureInfo(furniture,mapTypes.get(t),mapBrands.get(b)));
            }
        }
        return furnitureInfos;
    }
}
