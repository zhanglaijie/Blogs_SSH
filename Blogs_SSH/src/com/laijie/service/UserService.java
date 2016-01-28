package com.laijie.service;

import com.laijie.po.User;

public interface UserService {
	//�û�ע��
	public boolean registerUser(User user);
	
	//�û���½
	public boolean loginUser(User user);
}
