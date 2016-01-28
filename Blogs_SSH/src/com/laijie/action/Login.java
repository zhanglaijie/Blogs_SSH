package com.laijie.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.laijie.po.User;
import com.laijie.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
	private String username;
	private String password;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//���request
		HttpServletRequest request = ServletActionContext.getRequest();
		if(userService.loginUser(user)) {
			request.setAttribute("url", "user/getBlogInfo.action");
			request.setAttribute("info", "��½�ɹ�");
			//��username���浽session��Χ��
//			HttpSession session =request.getSession();
			Map session = ActionContext.getContext().getSession();
//			session.setAttribute("username", username);	
			session.put("username", username);
			return SUCCESS;
		} else {
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "��½ʧ��");
			return ERROR;
		}
	}

}
