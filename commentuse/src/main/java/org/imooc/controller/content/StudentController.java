package org.imooc.controller.content;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.imooc.bean.Student;
import org.imooc.constant.PageCodeEnum;
import org.imooc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/student")
public class StudentController {
     
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value="/addInit")
	 public String addInit(Student student) {
		 return "/student/studentAdd";
	 }
	 
     @RequestMapping
	 public String init(Model model,HttpServletRequest request) {
    	 Student student=new Student();
	   	 model.addAttribute("studentList",studentService.selectByPage(student));
	   	 model.addAttribute("searchParam",student);
		 return "/student/list";
	 }
     
     @RequestMapping(value="/query")
	 public String list(Model model,@RequestParam(value="currentPage")int id,
			 @RequestParam(value="name")String name) {
    	 Student s=new Student();
    	 s.getPage().setCurrentPage(id);
    	 s.setName(name);
	   	 model.addAttribute("studentList",studentService.selectByPage(s));
	   	 model.addAttribute("searchParam",s);
		 return "/student/list";
	 }
     
	 
	 @RequestMapping(value="/remove")
	 public String remove(@RequestParam(value="id")int id,Model model) {
		 if(studentService.remove(id)) {
			 model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
		 }else {
			 model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_FAIL);
		 }
		 return "forward:/student/";
	 }
	 
	 @RequestMapping(value="/modify")
	 public String modify(Student student,Model model) {
		 if(studentService.modify(student)) {
			 model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
		 }else {
			 model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
		 }
		 return "forward:/student/";
	 }
	 
	 @RequestMapping(value="/modifyInit")
	 public String modifyInit(@RequestParam(value="id")int id,Model model) {
		 model.addAttribute("student", studentService.selectById(id));
		 return "/student/studentModify";
	 }
	 
	 
	 @RequestMapping(value="/add")
	 public String add(Student student,Model model) {
		 if(studentService.insert(student)) {
			 model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
		 }else {
			 model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
		 }
		 return "forward:/student/";
	 }
	 
	 @RequestMapping(value="/queryMaxAndAvg")
	 public String queryMaxAvg(Model model) {
		 model.addAttribute("maxSubject", studentService.selectMaxBySubject());
		 model.addAttribute("avgSubject", studentService.selectAvgBySubject());
		 return "forward:/student/";
	 }
	
	/**
	 * 删除
	 */
	@RequestMapping("/removeBatch")
	public String removeBatch(@RequestParam("subString") String ids, Model model) {
		if (studentService.deleteBatch(ids) != 0) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
		} else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_FAIL);
		}
		return "forward:/student/";
	}
	 
	 
	 
	 
	 
	 
	 
	 
}
