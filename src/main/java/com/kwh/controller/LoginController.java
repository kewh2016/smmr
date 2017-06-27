package com.kwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwh.common.TreeNode;
import com.kwh.service.ResourceService;
import com.kwh.service.UserService;
import com.kwh.utils.JsonUtils;
import com.kwh.utils.StringUtils;

@Controller
public class LoginController {

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(String userNo, String password) {
		if (StringUtils.isBlank(userNo, password)) {
			return "login";
		}
		if (userService.authentication(userNo, password))
			return "redirect:index";
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(String userNo) {
		userService.cancellation(userNo);
		return "login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		List<TreeNode> menu = resourceService.getMenu(userService.getCurrentUser());
		model.addAttribute("menu", JsonUtils.parseJSON(menu));
		return "index";
	}
}
