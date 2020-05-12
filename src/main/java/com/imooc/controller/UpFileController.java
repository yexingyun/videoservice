package com.imooc.controller;

import com.imooc.domain.Result;
import com.imooc.domain.Video;
import com.imooc.repository.UserRepository;
import com.imooc.repository.VideoRepository;
import com.imooc.service.GirlService;
import com.imooc.service.VideoService;
import com.imooc.utils.L;
import com.imooc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author xjj
 */
@Controller
public class UpFileController {


    @Autowired
    private VideoService videoService;

    @GetMapping("/file")
    public String html() {
        return "/index.html";
    }

    @GetMapping("/show")
    public String showimg() {
        return "/img.html";
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public Result uploadFile(HttpServletRequest httpServletRequest, @RequestParam("userid") String userid, @RequestParam("videoTitle") String videoTitle,@RequestParam("type") Integer type) {
        /* 1、设置文件到本地的文件夹位置 */
        //key===uploadFile
        System.out.println("----------------------------==6666666666===================");
        L.d("userid==" + userid);
        L.d("videoTitle==" + videoTitle);

        String realPath = null;
        try {
            /* 这里获得的路径是项目的target/classes/upload*/
            realPath = ResourceUtils.getURL("classpath:").getPath() + "/upload";
            realPath = "C:\\upload";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /* 如果文件夹不存在，则创建该文件夹 */
        File dir = new File(realPath);
        if (!dir.isDirectory()) {
            dir.mkdirs();
        }
        /* 2、获取上传的文件名为uploadFile的list，这个文件名是upload页面上input的name */
        List<MultipartFile> uploadFiles = ((MultipartHttpServletRequest) httpServletRequest).getFiles("uploadFile");
        /* 3、开始将文件移动到目标路径下 */
        try {
            Video video = new Video();

            for (MultipartFile uploadFile : uploadFiles) {
                String filename = uploadFile.getOriginalFilename();
                L.e("file====" + filename);
                String[] split = filename.split("\\.");
                String houzui = "." + split[split.length - 1];
                filename = videoTitle + houzui;
                File fileServer = new File(dir, filename);
                uploadFile.transferTo(fileServer);
                video.setFilename(filename);
                video.setType(type);
                video.setUserid(userid);
//                L.d(httpServletRequest.getRequestURI());
//                L.d(httpServletRequest.getServletPath());
//                L.d(httpServletRequest.getContextPath());
//                L.d(httpServletRequest.getRemoteAddr());
//                L.d(httpServletRequest.getRemotePort()+"");
                video.setUrl("/images/"+filename);
                video.setVideoTitle(videoTitle);
                videoService.insertUrl(video);
            }

            return ResultUtil.success(video,"上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtil.error("上传失败");
    }

    @RequestMapping("/download")
    public String downLoad(@RequestParam("filename") String fileName, HttpServletResponse response) {
//        String filename="2.jpg";
        String filename = fileName;
//        String filePath = "F:/test" ;
        String filePath = null;
        try {
            /* 这里获得的路径是项目的target/classes/upload*/
            filePath = ResourceUtils.getURL("classpath:").getPath() + "/upload";
//            realPath= "C:\\upload";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File(filePath + "/" + filename);
        if (file.exists()) { //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
