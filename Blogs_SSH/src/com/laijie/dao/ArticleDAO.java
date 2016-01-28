package com.laijie.dao;

import java.util.List;

import com.laijie.fenye.Page;
import com.laijie.po.Article;

public interface ArticleDAO {
	//����һ��add�������������沩������
	public void add(Article article);
	
	//����һ��queryUserAll,����ȡ���û�����������
	public List<Article> queryUserAll(String username);
	
	//����û������ܼ�¼��
	public int queryUserAllCount(String username);
	
	//����ҳ��Ϣ��ѯ�û��ļ�¼
	public List<Article> queryByPage(String username,Page page);
	
	//����������µ��ܼ�¼��
	public int queryAllCount();
	
	//����ҳ��Ϣ��ѯ��¼
	public List<Article> queryAllByPage(Page page);
	
	//��ID��ѯ����
	public Article queryById(int id);
}
