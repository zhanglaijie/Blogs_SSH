package com.laijie.rss;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.laijie.po.Article;

public class CreateRss {
	public static void publishRss(List<Article> list, String filePath) {
		try {
			FileWriter fw = new FileWriter(filePath);							//�ļ������
			BufferedWriter bw = new BufferedWriter(fw);							//������
			bw.write("<?xml version=\"1.0\" encoding=\"gbk\"?>\r\n");			//д��ͷ������
			bw.write("<rss version=\"2.0\" xmlns:atom=\"" +
										"http://www.w3.org/2005/Atom\"\r\n");
			bw.write("xmlns:cf=\"http://www.microsoft.com/" +
											"schemas/rss/core/2005\"\r\n");
			bw.write("xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\r\n");
			bw.write("xmlns:trackback=\"http://madskills.com/public/" +
									"xml/rss/module/trackback/\"\r\n");
			bw.write("xmlns:wfw=\"http://wellformedweb.org/CommentAPI/\"\r\n");
			bw.write("xmlns:slash=\"http://purl.org/rss/1.0/modules/slash/\"\r\n>");
			bw.write("<channel>\r\n");												//Ƶ����Ϣ
			bw.write("<title>�����˲Ų�����</title>\r\n");								//����
			bw.write("<link>http://localhost:8080/JavaPrj_4/login.jsp</link>\r\n");	//���ӵ�ַ
			bw.write("<description>רע������˲ŵ�����</description>\r\n");			//Ƶ������
			for(Article art : list) {
				bw.write("<item>\r\n");												//��Ŀ
				bw.write("<title>" + art.getTitle()+"</title>\r\n");				//��Ŀ����
				bw.write("<link>http://localhost:8080/JavaPrj_4/user/" +
						"showArticle.action?id = " + art.getId() + "</link>\r\n");	//��Ŀ���ӵ�ַ
				bw.write("<description>" + art.getContent() + "</description>\r\n");//��Ŀ����
				bw.write("<author>" + art.getUsername() + "</author>\r\n");			//����
				bw.write("<pubDate>" + art.getDate() + "</pubDate>\r\n");			//����ʱ��
				bw.write("</item>\r\n");
			}
			bw.write("</channel>\r\n");
			bw.write("</rss>\r\n");
			//�ر���
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
