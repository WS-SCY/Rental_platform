package com.mymall.dao;

import com.mymall.bean.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseDao {
    public List<House> getAllHouse();
}
