package org.imooc.controller.content;

import java.util.List;

import javax.annotation.Resource;

import org.imooc.bean.Business;
import org.imooc.constant.DicTypeConst;
import org.imooc.constant.PageCodeEnum;
import org.imooc.dto.BusinessDto;
import org.imooc.service.BusinessService;
import org.imooc.service.DicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/businesses")
public class BusinessesController {

	@Resource
	private DicService dicService;

	@Resource
	private BusinessService businessService;

	
	@RequestMapping
	public String list(Model model,Business business) {
		List<Business> list=businessService.searchByPage(business);
		model.addAttribute("list", list);
		model.addAttribute("searchParam",business);
		return "/content/businessList";
	}
	
	@RequestMapping(value="/search")
	public String search(Model model,@RequestParam(value="currentPage")int id,
			@RequestParam(value="title")String title) {
		Business business=new Business();
		business.getPage().setCurrentPage(id);
		business.setTitle(title);
		List<Business> list=businessService.searchByPage(business);
		model.addAttribute("list", list);
		model.addAttribute("searchParam",business);
		return "/content/businessList";
	}
	

	/**
	 * 删除商户
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") Long id,Model model) {
		if(businessService.deletById(id)==1) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
		}else {
			model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.REMOVE_FAIL);
		}
		return "redirect:/businesses";
	}

	/**
	 * 商户新增页初始化
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addInit(Model model) {
		model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
		model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
		return "/content/businessAdd";
	}

	/**
	 * 商户新增
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String add(BusinessDto dto,RedirectAttributes attr) {
		if(businessService.add(dto)) {
			attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
			return "redirect:/businesses";
		} else {
			attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
			return "redirect:/businesses/addPage";
		}
	}

	/**
	 * 商户修改页初始化
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String modifyInit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
		model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
		model.addAttribute("modifyObj", businessService.getById(id));
		return "/content/businessModify";
	}

	/**
	 * 商户修改
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String modify(@PathVariable("id") Long id, BusinessDto dto,Model model) {
		if(businessService.modify(dto)==1) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
		}else {
			model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.MODIFY_FAIL);
		}
		return "redirect:/businesses";
	}
}