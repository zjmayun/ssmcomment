package org.imooc.dao;

import java.util.List;

import org.imooc.bean.Ad;
import org.imooc.bean.Student;

public interface StudentDao {
    int insert(Student student);
    
    int remove(int id);
    
    int modify(Student student);
    
    Student selectById(int id);
    
    List<Student> getAll();
    
    List<Student> selectByPage(Student student);
    
    List<Student> selectByMaxSubject();
    
    List<Student> selectByAverage();
    
    int deleteBatch(List ids);
    
}