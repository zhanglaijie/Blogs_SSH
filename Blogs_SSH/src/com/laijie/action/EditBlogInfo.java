package com.laijie.action;

import java.util.Map;

import com.laijie.po.BlogInfo;
import com.laijie.service.BlogInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditBlogInfo extends ActionSupport {
	private String blogtitle;
	private String idiograph;
	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	public String getBlogtitle() {
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	public String getIdiograph() {
		return idiograph;
	}

	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}

	public String execute() throws Exception {
//		//���request
//		HttpServletRequest request = ServletActionContext.getRequest();
//		//���session
//		HttpSession session =request.getSession();
//		//���username
//		String username = (String) session.getAttribute("username");
		
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		BlogInfo blogInfo = new BlogInfo();
		//�����û���
		blogInfo.setUsername(username);
		//���ò��ͱ���
		blogInfo.setBlogtitle(blogtitle);
		//���ø���ǩ��
		blogInfo.setIdiograph(idiograph);
		//����ҵ���߼�������������
		blogInfoService.setBlogInfo(blogInfo);
		
		return this.SUCCESS;
	}

}
