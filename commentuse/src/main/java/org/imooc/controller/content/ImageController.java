package org.imooc.controller.content;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.imooc.bean.Person;
import org.imooc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/person")
public class ImageController {

	
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/register")
	public String index() {
		return "/person/register";
	}
	
	
	 @RequestMapping(value="/addUser")
	 public String add(Person person,MultipartFile file,HttpServletRequest request) {
		 personService.add(person, file, request);
		 return "redirect:/person/getAll";
	 }
	 
	 @RequestMapping(value="/getAll")
	 public String getAll(Model model) {
		 List<Person> list=personService.getAll();
		 model.addAttribute("personList", list);
		 return "/person/userList";
	 }
}
