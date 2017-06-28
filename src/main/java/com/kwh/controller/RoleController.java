package com.kwh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwh.dao.RoleMapper;
import com.kwh.entity.Role;

@Controller
@RequestMapping("/role")
public class RoleController {


	@Autowired
	private RoleMapper roleMapper;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("roles", roleMapper.selectByExample(null));
		return "role/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser() {
		return "role/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(Role role) {
		roleMapper.insert(role);
		return "redirect:list";
	}
}
