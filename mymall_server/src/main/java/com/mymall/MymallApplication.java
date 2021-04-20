package com.mymall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.mymall.dao")
@SpringBootApplication
public class MymallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymallApplication.class, args);
    }

}




// // 打包war需要这个启动类，发布到服务器上
// @Override
// protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
//    System.out.print("视频上传项目启动类2.==="+"\n");
//    return application.sources(ShangchuanApplication.class);
// }