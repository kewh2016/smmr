package com.kwh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwh.dao.ResourceMapper;
import com.kwh.entity.Resource;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceMapper resourceMapper;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("resources", resourceMapper.selectByExample(null));
		return "resource/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		return "resource/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(Resource resource) {
		resourceMapper.insert(resource);
		return "redirect:list";
	}
}
