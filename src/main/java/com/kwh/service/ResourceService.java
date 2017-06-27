package com.kwh.service;

import java.util.List;

import com.kwh.common.TreeNode;
import com.kwh.entity.User;

public interface ResourceService {

	List<TreeNode> getMenu(User user);

}
