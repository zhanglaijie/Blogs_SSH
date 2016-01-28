package com.laijie.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.laijie.fenye.Page;
import com.laijie.fenye.Result;
import com.laijie.po.Article;
import com.laijie.po.BlogInfo;
import com.laijie.service.ArticleService;
import com.laijie.service.BlogInfoService;
import com.laijie.service.CritiqueService;
import com.laijie.service.DianjiliangService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowArticle extends ActionSupport {
	// ҵ���߼��������
	private ArticleService articleService;
	// id����
	private int id;
	// �������ҵ���߼����
	private DianjiliangService dianjiliangService;
	// ���۵�ҵ���߼����
	private CritiqueService critiqueService;
	//���õ�ǰҳ
	private int currentPage;
	
	//username
	private String username;
	
	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

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

	public CritiqueService getCritiqueService() {
		return critiqueService;
	}

	public void setCritiqueService(CritiqueService critiqueService) {
		this.critiqueService = critiqueService;
	}

	public DianjiliangService getDianjiliangService() {
		return dianjiliangService;
	}

	public void setDianjiliangService(DianjiliangService dianjiliangService) {
		this.dianjiliangService = dianjiliangService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public String execute() throws Exception {
		// ���������õ�request��Χ
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��ID��ѯ����
		Article article = articleService.showArticle(id);
		// ����û�IP
		String IP = request.getRemoteAddr();
		// ��õ�ǰʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stime = sdf.format(new Date());
		Date time = sdf.parse(stime);

		if (!dianjiliangService.isVistor(id, IP, time)) {
			// ���������
			article.setHasread(article.getHasread() + 1);
		}
		// �����µ�Article���浽��ݱ���
		articleService.addArticle(article);
		
		
		//��ʾ����
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(5);
		
		Result result = critiqueService.showCritiqueByPage(id, page);
		
		request.setAttribute("page", result.getPage());
		request.setAttribute("allCri", result.getList());
		request.setAttribute("article", article);
		
		//ȡ�ø��Ի�����
		//ͨ��ҵ���߼��������ѯ
		if(username != null || !"".equals(username)) {
			Map session = ActionContext.getContext().getSession();
			BlogInfo bloginfo  = blogInfoService.getBlogInfo(username);
			if(bloginfo != null) {
				session.put("blogtitle", bloginfo.getBlogtitle());
				session.put("idiograph", bloginfo.getIdiograph());
			}
		}
		return this.SUCCESS;
	}

}
