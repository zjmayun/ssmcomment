package org.imooc.service;

import org.imooc.bean.Student;

public interface StudentService {
	int insert(Student student);

	int remove(int id);

	int modify(Student student);

	Student selectById(int id);
}
