package com.laijie.service;

import com.laijie.po.BlogInfo;

public interface BlogInfoService {
	//���ò��͸��Ի�����
	public void setBlogInfo(BlogInfo blogInfo);
	
	//��ò��͸��Ի�����
	public BlogInfo getBlogInfo(String name);
}
