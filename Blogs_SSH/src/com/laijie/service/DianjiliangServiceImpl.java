package com.laijie.service;

import java.util.Date;

import com.laijie.dao.DianjiliangDAO;
import com.laijie.po.Dianjiliang;

public class DianjiliangServiceImpl  implements DianjiliangService{
	private DianjiliangDAO dianjiliangDAO;

	public DianjiliangDAO getDianjiliangDAO() {
		return dianjiliangDAO;
	}

	public void setDianjiliangDAO(DianjiliangDAO dianjiliangDAO) {
		this.dianjiliangDAO = dianjiliangDAO;
	}

	public boolean isVistor(int AId, String IP, Date time) {
		if(dianjiliangDAO.queryByAId(AId, IP, time).size() != 0) {
			System.out.println("��IP����������");
			//��ʾ�û��Ѿ�������ˡ�
			return true;
		} else {
			System.out.println("��IP����û�е����");
			//��ʾ�û�û�е����
			Dianjiliang djl = new Dianjiliang();
			djl.setAId(AId);
			djl.setIp(IP);
			djl.setTime(time);
			//�����¼
			dianjiliangDAO.addJilu(djl);
			return false;
		}
	}
	
	
}
