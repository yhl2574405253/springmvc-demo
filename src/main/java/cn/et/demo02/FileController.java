package cn.et.demo02;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URLEncoder;

@RestController
@RequestMapping("file")
public class FileController {
    @RequestMapping(value = "fileUpload")
    public String fileUpload(MultipartFile fileName) throws Exception{
        if (fileName !=null){
            //获取文件的名字
            String filename = fileName.getOriginalFilename();
            //创建一个文件存放的目录
            String path = "D:\\file\\";
            //判断文件夹是否存在不存在就创建
            if(!new File(path).exists())   {
                new File(path).mkdirs();
            }
            //将文件写入设置好的路径
            fileName.transferTo(new File(path+filename));
            return "UPLOAD SUCCESS!!";
        }
        return "UPLOAD FAILURE!!";
    }

    @GetMapping(value = "fileDownload")
    public ResponseEntity<byte[]> fileDownload(String fileName) throws Exception{
        //文件路径
        String path = "D:\\file\\"+fileName;
        //需要下载的目录文件
        File file = new File(path);
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        //设置下载的文件的名称  转换文件名的编码
        headers.setContentDispositionFormData("attachment", URLEncoder.encode(fileName,"UTF-8"));
        //读取目标文件为二进制数组
        byte[] fileByte = FileCopyUtils.copyToByteArray(file);
        //构建ResponseEntity对象
        ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(fileByte,headers,HttpStatus.CREATED);
        //将对象返回
        return re;
    }

}

