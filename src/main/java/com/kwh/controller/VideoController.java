package com.kwh.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kwh.exception.BizException;

@Controller
public class VideoController {
    @RequestMapping(value = "/upload", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody()
    public String uploadFile(MultipartFile file) {
	String path = "/usr/file";
	String fileName = file.getOriginalFilename();
	File targetFile = new File(path, fileName);
	if (!targetFile.exists()) {
	    targetFile.mkdirs();
	}
	try {
	    file.transferTo(targetFile);
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
	List<Map<String, String>> list = new ArrayList<>();
	File file = new File("/usr/file");
	File[] files = file.listFiles();
	for (File file2 : files) {
	    Map<String, String> map = new HashMap<>();
	    map.put("name", file2.getName());
	    map.put("path", file2.getAbsolutePath());
	    list.add(map);
	}
	model.addAttribute("files", list);
	return "file/files";
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public void fileLoad(String path, HttpServletResponse response) throws BizException {
	if (path == null || !path.startsWith("/usr/file")) {
	    throw new BizException("文件路径不正确！");
	}
	File file = new File(path);

	if (!file.exists()) {
	    throw new BizException("文件路径不存在！");
	}
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
