package org.imooc.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public boolean insert(Student student) {
		return studentDao.insert(student)==1;
	}

	@Override
	public boolean remove(int id) {
		return studentDao.remove(id)==1;
	}

	@Override
	public boolean modify(Student student) {
		return studentDao.modify(student)==1;
	}

	@Override
	public Student selectById(int id) {
		return studentDao.selectById(id);
	}
	
	public List<Student> getAll(){
		return studentDao.getAll();
	}

	@Override
	public List<Student> selectByPage(Student student) {
		return studentDao.selectByPage(student);
	}

	@Override
	public List<Student> selectMaxBySubject() {
		List<Student> list=studentDao.selectByMaxSubject();
		return list;
	}

	@Override
	public List<Student> selectAvgBySubject() {
		return studentDao.selectByAverage();
	}
 
	@Override
	public int deleteBatch(String ids) {
		if(ids==null&&ids.length()==0) {
			return 0;
		}
		String []idArray=ids.split(",");
		List list=new ArrayList();
		for(int i=0;i<idArray.length;i++) {
			list.add(idArray[i]);
		}
		return studentDao.deleteBatch(list);
	}
	
	

}
