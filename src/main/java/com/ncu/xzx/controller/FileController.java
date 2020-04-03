package com.ncu.xzx.controller;

import com.ncu.xzx.model.FileDto;
import com.ncu.xzx.model.FileVo;
import com.ncu.xzx.model.FileDo;
import com.ncu.xzx.model.UserToken;
import com.ncu.xzx.service.FileService;
import com.ncu.xzx.service.UserLoadService;
import com.ncu.xzx.service.UserService;
import com.ncu.xzx.service.UserTokenService;
import com.ncu.xzx.utils.Response;
import com.ncu.xzx.utils.ResponseCode;
import com.ncu.xzx.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.*;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    UserTokenService userTokenService;

    @Autowired
    FileService fileService;

    @Autowired
    UserLoadService userLoadService;

    @Autowired
    UserService userService;

    public static String FILE_PATH = "/Users/vivo/upload";

    public static String PAPER_PATH = "/Users/vivo/paper";


//    public static String PATH = "D:\\fileupload";

    /**
     * 上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @UserLoginToken
    public Response upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        UserToken userToken = userTokenService.getByToken(token);
        int userId = userToken.getUserId();

        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        //固定保存路径
        //判断上传文件的保存目录是否存在
        File targetFile = new File(FILE_PATH);
        if (!targetFile.exists() && !targetFile.isDirectory()) {
            System.out.println(FILE_PATH + "  目录不存在，需要创建");
            //创建目录
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(FILE_PATH + File.separator + fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FileDo fileObject = new FileDo();
        fileObject.setUserId(userId);
        fileObject.setFileName(fileName);
        fileObject.setFilePath(FILE_PATH + fileName);

        int result = fileService.upload(fileObject);

        if (result > 0) {
            userLoadService.insertOrUpdateUserLoad(userId, "upload");
            return new Response("");
        }

        return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "");

    }

    /**
     * 获取下载链接
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/download-url")
    @UserLoginToken
    public Response downloadUrl(@RequestParam("type") String type, @RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization");
        UserToken userToken = userTokenService.getByToken(token);
        int userId = userToken.getUserId();
        if ("file".equals(type)) {
            userLoadService.insertOrUpdateUserLoad(userId, "download");

            FileDo fileObject = new FileDo();
            fileObject.setUserId(userId);
            fileObject.setFileName(fileName);
            fileObject.setFilePath(FILE_PATH + fileName);

            fileService.download(fileObject);
        }
//        try {
//            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        return new Response("/file/download/" + fileName);

    }

    /**
     * 下载
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/download/{fileName}")
    public Response download(@PathVariable("fileName") String fileName, @RequestParam("type") String type, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("type  " + type);
        System.out.println("fileName   "+fileName);
        // 得到要下载的文件, linux为/  Windows为\\
        String pathName = "";
        if ("file".equals(type)) {
            pathName = FILE_PATH + File.separator + fileName;
        } else if ("paper".equals(type)) {
            pathName = PAPER_PATH + File.separator + fileName;
        }
        System.out.println("pathName  " + pathName);
        File file = new File(pathName);
        //如果文件不存在
        if (!file.exists()) {
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "文件不存在");
        }
        try {
            //设置响应头，控制浏览器下载该文件
            response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("content-transfer-encoding","binary");
            //读取要下载的文件，保存到文件输入流
            FileInputStream in = null;

            in = new FileInputStream(pathName);
            //创建输出流
            OutputStream out = response.getOutputStream();
            //创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            //循环将输入流中的内容读取到缓冲区当中
            while ((len = in.read(buffer)) > 0) {
                //输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Response("");

    }


    /**
     * 文件预览，集成kkfileview  链接：https://gitee.com/kekingcn/file-online-preview/wikis/pages
     *
     * 例子：
     * var originUrl = 'http://10.12.65.57:8888/file/preview/养成活动攻略-2.19.docx';
     * window.open('http://127.0.0.1:8012/onlinePreview?url='+encodeURIComponent(originUrl));
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/preview/{fileName}")
    public Response preview(@PathVariable String fileName, @RequestParam("type") String type, HttpServletRequest request, HttpServletResponse response) {
        //得到要下载的文件, linux为/  Windows为\\
        String pathName = "";
        String previewPath = "";
        if ("file".equals(type)) {
            pathName = FILE_PATH + File.separator + fileName;
            previewPath = "file:///" + FILE_PATH + fileName;
        } else if ("paper".equals(type)) {
            pathName = PAPER_PATH + File.separator + fileName;
            previewPath = "file:///" + PAPER_PATH + fileName;
        }
        File file = new File(pathName);
        //如果文件不存在
        if (!file.exists()) {
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "");
        }

        response.reset();
        //处理文件名
        String realname = fileName.substring(fileName.indexOf("_") + 1);
        try {
            //读取要下载的文件，保存到文件输入流
            FileInputStream in = null;
            in = new FileInputStream(pathName);

            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            URL u = new URL(previewPath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + fileName);

            //创建输出流
            OutputStream out = response.getOutputStream();
            //创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            //循环将输入流中的内容读取到缓冲区当中
            while ((len = in.read(buffer)) > 0) {
                //输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Response("");

    }

    /**
     * 获取所有文件
     * @return
     */
    @GetMapping("/list")
    @UserLoginToken
    public Response getFileList(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize) {
        int offset = (pageIndex - 1) * pageSize;
        List<FileDo> fileDoList = fileService.getFileList(offset, pageSize);
        List<FileVo> fileVoList = fileService.FileDoToFileVo(fileDoList);
        int count = fileService.countAllFiles();
        FileDto fileDto = new FileDto();
        fileDto.setFileVoList(fileVoList);
        fileDto.setCount(count);
        return new Response(fileDto);
    }

    /**
     * 按照文件名模糊查询
     * @param fileName
     * @return
     */
    @RequestMapping("/query")
    @UserLoginToken
    public Response getByFileName(@RequestParam("fileName") String fileName) {
        List<FileDo> fileDoList = fileService.getByFileName(fileName);
        List<FileVo> fileVoList = fileService.FileDoToFileVo(fileDoList);
        FileDto fileDto = new FileDto(fileVoList, fileVoList.size());
        return Response.ok(fileDto);
    }

}
