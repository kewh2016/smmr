package com.kwh.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kwh.constants.UserConstants;
import com.kwh.dao.UserMapper;
import com.kwh.entity.User;
import com.kwh.entity.UserExample;
import com.kwh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean authentication(String userNo, String password) {
		User user = getUserByUserNo(userNo);
		if (user == null)
			return false;
		if (DigestUtils.sha256Hex(password + userNo).equals(user.getPassword())) {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute(UserConstants.SESSION_USER, user);
			return true;
		}
		return false;
	}

	@Override
	public void cancellation(String userNo) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute(UserConstants.SESSION_USER);
	}

	@Override
	public User getUserByUserNo(String userNo) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNoEqualTo(userNo);
		List<User> users = userMapper.selectByExample(userExample);
		return CollectionUtils.isEmpty(users) ? null : users.get(0);
	}

}
