package com.kwh.service;

import com.kwh.entity.User;

public interface UserService {
	
	/**
	 * 认证
	 * @param userNo
	 * @param password
	 * @return
	 */
	boolean authentication(String userNo, String password);

	User getUserByUserNo(String userNo);
	
	/**
	 * 注销
	 * @param userNo
	 * @return
	 */
	void cancellation(String userNo);
}
