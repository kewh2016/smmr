package com.kwh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwh.dao.RoleMapper;
import com.kwh.dao.RoleResourceMapper;
import com.kwh.dao.custom.RoleResourceExtMapper;
import com.kwh.entity.RoleResource;
import com.kwh.entity.RoleResourceExample;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
	@Autowired
	private RoleResourceMapper roleResourceMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RoleResourceExtMapper roleResourceExtMapper;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("roleResources", roleResourceExtMapper.getRoleResources(null));
		return "authority/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, String roleId) {
		model.addAttribute("role", roleMapper.selectByPrimaryKey(Long.parseLong(roleId)));
		model.addAttribute("roleResources", roleResourceExtMapper.getRoleResources(roleId));
		model.addAttribute("resources", roleResourceExtMapper.getRoleNotAllowResources(roleId));
		return "authority/add";
	}

	@RequestMapping(value = "/addallow", method = RequestMethod.GET)
	public String add(RoleResource roleResource) {
		roleResourceMapper.insert(roleResource);
		return "redirect:add?roleId=" + roleResource.getRoleId();
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(RoleResource roleResource) {
		RoleResourceExample example = new RoleResourceExample();
		example.createCriteria().andRoleIdEqualTo(roleResource.getRoleId())
				.andResourceIdEqualTo(roleResource.getResourceId());
		roleResourceMapper.deleteByExample(example);
		return "redirect:add?roleId=" + roleResource.getRoleId();
	}
}
