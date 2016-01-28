package com.laijie.service;

import java.util.List;

import com.laijie.fenye.Page;
import com.laijie.fenye.Result;
import com.laijie.po.Article;

public interface ArticleService {
	//�������µı���
	public void addArticle(Article article);
	
	//ȡ���û����е�����
	public List<Article> showUserAllArticle(String username);
	
	//��ҳ��ʾ�û�����
	public Result showUserArticleByPage(String username,Page page);
	
	//��ҳ��ʾȫ������
	public Result showArticleByPage(Page page);
	
	//��ʾ����
	public Article showArticle(int id);
	
	//���������
	public int getCritiqueCount(int AId);
}
