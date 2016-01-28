package com.laijie.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class PhotoUpload  extends ActionSupport{
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String execute() throws Exception {
		//���username
		Map session = ServletActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		//����һ��������
		InputStream is = new FileInputStream(myFile);
		//�����ļ�����Ŀ¼
		String photoPath = 
			ServletActionContext.getServletContext().getRealPath("/user/photo/" + username);
		File filePhotoPath = new File(photoPath);
		if(!filePhotoPath.isDirectory()) {
			filePhotoPath.mkdir();
		}
		
		//��������ļ�������
		String extension = FilenameUtils.getExtension(this.getMyFileFileName());
		String filename = UUID.randomUUID().toString() + "."+ extension;
		
		//����Ŀ���ļ�
		File tofile = new File(photoPath,filename);
		//ʹ�����������װĿ���ļ�
		OutputStream os = new FileOutputStream(tofile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		//�ر�������
		is.close();
		//�ر������
		os.close();
		
		return this.SUCCESS;
	}

	
}
