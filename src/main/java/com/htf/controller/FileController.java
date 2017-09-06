package com.htf.controller;

import com.htf.util.ShiroUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PC-FENG on 2017/9/4.
 */
@RestController
@RequestMapping("")
@Api(value = "文件上传",description = "文件上传")
public class FileController {
    private Logger logger = LoggerFactory.getLogger(FileController.class);
    @Value("${resources.user.photo.path}")
    private String imageDir;
    @Value("${sys.type}")
    private String sysType;

    /***
     * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
     *
     * @return
     */
    @RequestMapping(value = "/imgUpload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json;charset=UTF-8")
    public Map<String ,String > imgUpload(@RequestParam("file") MultipartFile file){
        Map<String ,String> map = new HashMap<>();
        String userId = ShiroUtils.getUserId();
        System.out.println(ShiroUtils.getUserId());
        String fileName = userId + "_" + System.currentTimeMillis() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String filePath = imageDir + userId;
//        String filePath = "G:\\htf\\resource\\" + userId;
        this.createFloder(sysType,filePath);
        File targetFile = new File(filePath,fileName);
        try {
            file.transferTo(targetFile);
            map.put("resourceURI",userId + "/" + fileName);
        }catch (Exception e){
        }
        return map;
    }


    private void createFloder(String sysType,String filePath){
        //sysType = 0 windows系统
        File targetFile = null;
        String [] existFilePath = filePath.replace("/","_").split("_");
        StringBuffer sb = new StringBuffer("");
        if("0".equals(sysType)){
            for (String s : existFilePath){
                if(s.indexOf(":") < 0){
                    sb.append("/" + s);
                    targetFile = new File(sb.toString());
                    if (!targetFile.exists()) {
                        targetFile.mkdir();
                    }
                }else{
                    sb.append(s);
                }
            }
        }else{
            //Linux系统
            for(String s : existFilePath){
                sb.append(s + "/");
                targetFile = new File(sb.toString());
                if (!targetFile.exists()) {
                    targetFile.mkdir();
                }
            }
        }
    }

}
