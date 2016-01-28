package com.laijie.dao;

import java.util.List;

import com.laijie.fenye.Page;
import com.laijie.po.Critique;

public interface CritiqueDAO {
	//�������
	public void addCritique(Critique critique);
	
	//���ָ�����µ�������
	public int queryCritiqueCount(int AId);
	
	//���Page����ѯָ�����µ�����
	public List<Critique> queryByPage(int AId,Page page);
}
