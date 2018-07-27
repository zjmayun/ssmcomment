package org.imooc.service;

import java.util.List;

import org.imooc.bean.Student;

public interface StudentService {
	boolean insert(Student student);

	boolean remove(int id);

	boolean modify(Student student);

	Student selectById(int id);
	
    List<Student> getAll();
	
	List<Student> selectByPage(Student student);
	
	List<Student> selectMaxBySubject();
	
	List<Student> selectAvgBySubject();
	
}
