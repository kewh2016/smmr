package com.kwh.service;

import java.util.List;

import com.kwh.common.TreeNode;
import com.kwh.entity.User;

public interface ResourceService {

	/**
	 * 获取用户资源
	 * @param user
	 * @param getAll false仅仅获取菜单
	 * @return
	 */
	List<TreeNode> getMenu(User user, boolean getAll);

}
