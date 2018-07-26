package org.imooc.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.imooc.bean.Person;
import org.imooc.dao.PersonDao;
import org.imooc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PersonServiceImpl implements PersonService{

	@Value("${adImage.savePath}")
	private String adImageSavePath;
	
	@Autowired
	private PersonDao personDao;
	

	@Override
	public boolean add(Person person, MultipartFile file,HttpServletRequest request) {
		if(file.getSize()>0&&file!=null) {
			String originalName=file.getOriginalFilename();
			String fileName=System.currentTimeMillis()+"-"+originalName;
			System.out.println(fileName);
//			String url=request.getSession().getServletContext().getRealPath("/upload");
			File file1=new File(adImageSavePath+fileName);
			if(!file1.exists()) {
				file1.mkdirs();
			}			
			try {
				file.transferTo(file1);
				person.setImgUrl("upload"+"/"+fileName);
				personDao.insert(person);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}


	@Override
	public List<Person> getAll() {
		return personDao.getAll();
	}

	
	
    
}
