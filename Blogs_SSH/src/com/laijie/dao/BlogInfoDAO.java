package com.laijie.dao;

import com.laijie.po.BlogInfo;

public interface BlogInfoDAO {
	//���ø��Ի�����
	public void save(BlogInfo info);
	//���
	public BlogInfo get(String username);
}
