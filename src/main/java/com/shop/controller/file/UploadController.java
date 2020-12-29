package com.shop.controller.file;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/native")
    public String nativeUpload(@RequestParam("file") MultipartFile file) {
        //获得目录绝对值
        String path=request.getSession().getServletContext().getRealPath("images");
        //目录名+文件名
        String filePath = path +"/"+ file.getOriginalFilename();
        File desFile = new File(filePath);
        if(!desFile.getParentFile().exists()){
            //目录不存在则创建其目录
            desFile.mkdirs();
        }
        try {
            //保存到该路径
            file.transferTo(desFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("path:---"+filePath);
        //返回文件名给前端
        return "http://34d538s283.qicp.vip/images/"+file.getOriginalFilename();
    }
//
//    @Autowired
//    private OSSClient ossClient;
//
//    @PostMapping("/oss")
//    public String ossUpload(@RequestParam("file") MultipartFile file,String folder){
//        String bucketName = "areioqingcheng";
//        String fileName= folder+"/"+ UUID.randomUUID()+"_"+file.getOriginalFilename();
//        try {
//            ossClient.putObject(bucketName, fileName, file.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "http://"+bucketName+"."+ ossClient.getEndpoint().toString().replace("http://","") +"/"+fileName;
//    }


}
