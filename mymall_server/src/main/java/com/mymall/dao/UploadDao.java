package com.mymall.dao;

import com.mymall.bean.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UploadDao {
    public Boolean UploadInfo(
            @Param(value = "distric") String distric,
            @Param(value = "storey") int storey,
            @Param(value = "area" ) int  area,
            @Param(value = "price") int price ,
            @Param(value = "homeownerid") String homeownerid,
            @Param(value = "rentedflag") int rentedflag,
            @Param(value = "shareflag") int shareflag,
            @Param(value = "brifintroduction") String brifintroduction,
            @Param(value = "gender") String gender,
            @Param(value = "icon") String icon,
            @Param(value = "introduction") String introduction
    );
}
