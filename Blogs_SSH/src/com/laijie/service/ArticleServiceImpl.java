package com.laijie.service;

import java.util.List;

import com.laijie.dao.ArticleDAO;
import com.laijie.dao.CritiqueDAO;
import com.laijie.fenye.Page;
import com.laijie.fenye.PageUtil;
import com.laijie.fenye.Result;
import com.laijie.po.Article;

public class ArticleServiceImpl implements ArticleService {
	private ArticleDAO articleDAO;
	private CritiqueDAO critiqueDAO;
	
	
	public CritiqueDAO getCritiqueDAO() {
		return critiqueDAO;
	}


	public void setCritiqueDAO(CritiqueDAO critiqueDAO) {
		this.critiqueDAO = critiqueDAO;
	}


	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}


	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}


	public void addArticle(Article article) {
		articleDAO.add(article);
	}


	public List<Article> showUserAllArticle(String username) {
		System.out.println(articleDAO.queryUserAllCount(username));
		return articleDAO.queryUserAll(username);
	}


	public Result showUserArticleByPage(String username, Page page) {
		page = PageUtil.createPage(page,articleDAO.queryUserAllCount(username));
		List<Article> all = articleDAO.queryByPage(username, page);
		Result result = new Result();
		result.setPage(page);
		result.setList(all);
		return result;
	}


	public Result showArticleByPage(Page page) {
		page = PageUtil.createPage(page,articleDAO.queryAllCount());
		List<Article> all = articleDAO.queryAllByPage(page);
		Result result = new Result();
		result.setPage(page);
		result.setList(all);
		return result;
	}


	public Article showArticle(int id) {
		return articleDAO.queryById(id);
	}


	public int getCritiqueCount(int AId) {
		return critiqueDAO.queryCritiqueCount(AId);
	}

}
