package com.laijie.fckeditor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.fckeditor.requestcycle.UserPathBuilder;

public class MyUserPath implements UserPathBuilder {

	public String getUserFilesPath(HttpServletRequest request) {
		//����һ��·�������·�������û���Ŀ¼
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		return "/userfiles/" + username;
	}

}
