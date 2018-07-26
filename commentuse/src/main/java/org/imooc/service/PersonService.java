package org.imooc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.imooc.bean.Person;
import org.imooc.dto.AdDto;
import org.springframework.web.multipart.MultipartFile;

public interface PersonService {
    
    boolean add(Person person,MultipartFile file,HttpServletRequest request);
    
    List<Person> getAll();
}
