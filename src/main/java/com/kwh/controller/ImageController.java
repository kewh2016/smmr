package com.kwh.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kwh.dao.ImageMapper;
import com.kwh.entity.Image;
import com.kwh.exception.BizRuntimeException;

@Controller
public class ImageController {

    @Autowired
    private ImageMapper imageMapper;

    @RequestMapping(value = "/upload", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody()
    public String uploadFile(MultipartFile file) {
        String path = "/usr/file";
        if (System.getProperty("os.name").toLowerCase().contains("window")) {
            path = "D:" + path;
        }
        String fileName = file.getOriginalFilename();
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            Image image = new Image();
            image.setName(fileName);
            image.setPath(path);
            imageMapper.insert(image);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return "上传成功!";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadFile() {
        return "file/upload";
    }

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public String files(Model model) {
        List<Image> list = imageMapper.selectByExample(null);
        model.addAttribute("files", list);
        return "file/files";
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public void fileLoad(String id, HttpServletResponse response) {
        Image image = imageMapper.selectByPrimaryKey(Long.parseLong(id));
        if (image == null) {
            throw new BizRuntimeException("文件不存在！");
        }
        File file = new File(image.getPath() +File.separator+ image.getName());
        try (OutputStream out = response.getOutputStream()) {
            response.reset();
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            out.write(FileUtils.readFileToByteArray(file));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
