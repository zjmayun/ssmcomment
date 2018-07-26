package org.imooc.controller.content;

import org.imooc.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/student")
public class StudentController {
     
	 public String add(Student student) {
		 return "/person/add";
	 }
	 
	 public String list() {
		 return "/person/list";
	 }
	 
	 public String remove(int id) {
		 return "/person/list";
	 }
}
