package com.laijie.service;

import com.laijie.fenye.Page;
import com.laijie.fenye.Result;
import com.laijie.po.Critique;

public interface CritiqueService {
	//�������
	public void addCritique(Critique critique);
	
	//��ҳ��ʾ����
	public Result showCritiqueByPage(int AId,Page page);
	
	//���ָ�����µ�������
	public int getCritiqueCount(int AId);
}
