package org.imooc.dao;

import java.util.List;

import org.imooc.bean.Ad;
import org.imooc.bean.Person;

public interface PersonDao {
    
    
    int insert(Person person);
    
    List<Person> getAll();
    
}