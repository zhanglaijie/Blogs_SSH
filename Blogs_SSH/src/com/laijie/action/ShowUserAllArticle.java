package com.laijie.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.laijie.fenye.Page;
import com.laijie.fenye.Result;
import com.laijie.po.Article;
import com.laijie.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUserAllArticle extends ActionSupport{
	private ArticleService articleService;
	private int currentPage;
	private String username;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	public String execute() throws Exception {
		if(username == null || "".equals(username)) {
			//����Ҫ���session
			Map session = ActionContext.getContext().getSession();
			//���username
			username = (String) session.get("username");
		}
		
		//ͨ�����ҵ���߼��������ɲ�ѯ
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(5);
		
		Result result = articleService.showUserArticleByPage(username, page);
		page = result.getPage();
		List<Article> all = result.getList();
		List critiqueCounts = new ArrayList();
		
		for(Article article : all) {
			critiqueCounts.add(articleService.getCritiqueCount(article.getId()));
		}
		
		//�Ѳ�ѯ���Ľ�����һ����Χ��request
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("all", all);
		request.setAttribute("page", page);
		request.setAttribute("critiqueCounts",critiqueCounts);
		return this.SUCCESS;
	}
	
}
