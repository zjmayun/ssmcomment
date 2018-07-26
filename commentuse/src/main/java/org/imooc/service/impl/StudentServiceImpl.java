package org.imooc.service.impl;

import org.imooc.bean.Student;
import org.imooc.dao.StudentDao;
import org.imooc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public int insert(Student student) {
		studentDao.insert(student);
		return 0;
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
