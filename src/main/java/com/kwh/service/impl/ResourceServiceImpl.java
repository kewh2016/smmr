package com.kwh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwh.common.TreeNode;
import com.kwh.dao.ResourceMapper;
import com.kwh.dao.RoleMapper;
import com.kwh.dao.RoleResourceMapper;
import com.kwh.entity.Resource;
import com.kwh.entity.Role;
import com.kwh.entity.RoleResource;
import com.kwh.entity.RoleResourceExample;
import com.kwh.entity.User;
import com.kwh.exception.BizRuntimeException;
import com.kwh.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceMapper resourceMapper;

	@Autowired
	private RoleResourceMapper roleResourceMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<TreeNode> getMenu(User user) {
		Role role = roleMapper.selectByPrimaryKey(user.getRoleId());
		if (role == null)
			throw new BizRuntimeException("用户信息有误");
		RoleResourceExample example = new RoleResourceExample();
		example.createCriteria().andRoleIdEqualTo(role.getId());
		List<RoleResource> roleResources = roleResourceMapper.selectByExample(example);
		List<TreeNode> treeNodes = new ArrayList<>();
		for (RoleResource roleResource : roleResources) {
			Resource resource = resourceMapper.selectByPrimaryKey(roleResource.getResourceId());
			TreeNode treeNode = new TreeNode();
			treeNode.setName(resource.getResourceName());
			treeNode.setUrl(resource.getResourceUrl());
			treeNode.setTarget("iframepage");
			treeNode.setId(resource.getId());
			if (null != resource.getParentId())
				treeNode.setpId(resource.getParentId());
			treeNodes.add(treeNode);
		}
		return treeNodes;
	}

}
