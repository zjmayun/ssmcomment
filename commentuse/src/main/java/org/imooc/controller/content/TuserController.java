package org.imooc.controller.content;

import org.imooc.bean.Tuser;
import org.imooc.dao.TuserDao;
import org.imooc.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/tuser")
public class TuserController {
     
	@Autowired
	private TuserService tuserService;
    
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		PageInfo<Tuser> t=tuserService.getAll(1, 5);
        model.addAttribute("list",t);
		return "/person/bootstrop";
	}
}
