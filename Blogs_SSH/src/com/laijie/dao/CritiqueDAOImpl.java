package com.laijie.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.laijie.fenye.Page;
import com.laijie.po.Critique;

public class CritiqueDAOImpl extends HibernateDaoSupport implements CritiqueDAO {

	public void addCritique(Critique critique) {
		this.getHibernateTemplate().save(critique);
	}

	public List<Critique> queryByPage(final int AId, final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select cri from Critique cri where cri.AId = ?");
				query.setParameter(0, AId);
				//����ÿҳ��ʾ���ٸ������ö����
				query.setMaxResults(page.getEveryPage());
				//�������
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
			
		});
	}

	public int queryCritiqueCount(int AId) {
		List find = this.getHibernateTemplate().find("select count(*) from Critique cri where cri.AId = ?",AId);
		return ((Long)find.get(0)).intValue();
	}

}
