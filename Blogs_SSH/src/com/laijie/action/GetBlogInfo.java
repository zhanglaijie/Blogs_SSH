package com.laijie.action;

import java.util.Map;

import com.laijie.po.BlogInfo;
import com.laijie.service.BlogInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetBlogInfo extends ActionSupport {

	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}
	
	public String execute() throws Exception {
		//���usrname
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		//ͨ��ҵ���߼��������ѯ
		BlogInfo bloginfo  = blogInfoService.getBlogInfo(username);
		
		if(bloginfo != null) {
			session.put("blogtitle", bloginfo.getBlogtitle());
			session.put("idiograph", bloginfo.getIdiograph());
		}
		return this.SUCCESS;
	}
}
