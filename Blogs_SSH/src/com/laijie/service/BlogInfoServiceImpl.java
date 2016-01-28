package com.laijie.service;

import com.laijie.dao.BlogInfoDAO;
import com.laijie.po.BlogInfo;

public class BlogInfoServiceImpl implements BlogInfoService {
	private BlogInfoDAO blogInfoDAO;
	
	public BlogInfo getBlogInfo(String username) {
		return blogInfoDAO.get(username);
	}

	public BlogInfoDAO getBlogInfoDAO() {
		return blogInfoDAO;
	}

	public void setBlogInfoDAO(BlogInfoDAO blogInfoDAO) {
		this.blogInfoDAO = blogInfoDAO;
	}

	public void setBlogInfo(BlogInfo blogInfo) {
		//ͨ�����DAO��������
		blogInfoDAO.save(blogInfo);
	}

}
