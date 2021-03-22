package com.mymall.controller;

import com.alibaba.fastjson.JSON;
import com.mymall.bean.House;
import com.mymall.bean.User;
import com.mymall.dao.HouseDao;
import com.mymall.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HouseController {
    @Autowired
    HouseDao houseDao;

    @GetMapping("/api/allhouse")
    public String allHouse(){
        List<House> resList  = houseDao.getAllHouse();
        return JSON.toJSONString(resList);
    }
}