package com.laijie.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.laijie.fenye.Page;
import com.laijie.po.Article;

public class ArticleDAOImpl extends HibernateDaoSupport implements ArticleDAO {

	//ʵ��add����
	public void add(Article article) {
		this.getHibernateTemplate().saveOrUpdate(article);
	}

	public List<Article> queryUserAll(String username) {
		List find = this.getHibernateTemplate().find("select art from Article art where art.username = ?", username);
		List<Article> list = find;
		return list;
	}

	public int queryUserAllCount(String username) {
		List find = this.getHibernateTemplate().find("select count(*) from Article art where art.username = ?",username);
		return ((Long)find.get(0)).intValue();
	}

	public List<Article> queryByPage(final String username, final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select art from Article art where art.username = ?");
				//���ò���
				query.setParameter(0, username);
				//����ÿҳ��ʾ���ٸ������ö����
				query.setMaxResults(page.getEveryPage());
				//�������
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
			
		});
	}

	public List<Article> queryAllByPage(final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select art from Article art order by art.date desc");
				//����ÿҳ��ʾ���ٸ������ö����
				query.setMaxResults(page.getEveryPage());
				//�������
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
			
		});
	}

	public int queryAllCount() {
		List find = this.getHibernateTemplate().find("select count(*) from Article art");
		return ((Long)find.get(0)).intValue();
	}

	public Article queryById(int id) {
		List find = this.getHibernateTemplate().find("select art from Article art where art.id = ?", id);
		return (Article) find.get(0);
	}

}
