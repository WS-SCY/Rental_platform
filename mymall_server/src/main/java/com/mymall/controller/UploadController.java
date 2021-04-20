package com.mymall.controller;
import com.mymall.dao.UploadDao;
import com.mymall.util.BASE64DecodedMultipartFile;
import com.mymall.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class UploadController {
    @Autowired
    UploadDao uploadDao;

    @PostMapping("/api/upload")
    public String addTeacher(@RequestParam(value = "distric", required = false,defaultValue = "null") String distric,
                             @RequestParam(value = "storey", required = false,defaultValue = "-1") int storey,
                             @RequestParam(value = "area", required = false,defaultValue = "-1") int  area,
                             @RequestParam(value = "price", required = false,defaultValue = "-1") int price ,
                             @RequestParam(value = "homeownerid", required = false,defaultValue = "null") String homeownerid,
                             @RequestParam(value = "rentedflag", required = false,defaultValue = "-1") int rentedflag,
                             @RequestParam(value = "shareflag", required = false,defaultValue = "-1") int shareflag,
                             @RequestParam(value = "brifintroduction", required = false,defaultValue = "null") String brifintroduction,
                             @RequestParam(value = "gender", required = false,defaultValue = "均可") String gender,
                             @RequestParam(value = "introduction", required = false,defaultValue = "null") String introduction,
                             @RequestParam(value = "file", required = false,defaultValue = "null") String base64File   )
    {
//        System.out.println(file.getSize());
        String fileName = new String();
        System.out.println(base64File);
        String filepath = "/mss/mss_admin/dist/pic/";
//        filepath = "C:\\Users\\Administrator\\Desktop\\pic\\";
        if(!base64File.equals("null")){
            MultipartFile file = BASE64DecodedMultipartFile.base64ToMultipart(base64File);

            if(file != null){
                fileName = FileUtil.upload(file,filepath, file.getOriginalFilename());
            }else{
                System.out.println("文件为空");
            }
            System.out.println(fileName);
        }
        uploadDao.UploadInfo(distric,storey,area,price,homeownerid,rentedflag,shareflag,brifintroduction,gender,"../pic/"+fileName,introduction );
        return "ok";
    }
}
