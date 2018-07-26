package org.imooc.service.impl;

import java.util.List;

import org.imooc.bean.Tuser;
import org.imooc.dao.TuserDao;
import org.imooc.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TuserServiceImpl implements TuserService{

	@Autowired
	private TuserDao tuserDao;
	
	@Override
	public PageInfo<Tuser> getAll(int currentPage,int pageSize) {
		System.out.println("hello moto");
		PageHelper.startPage(currentPage, pageSize);
		List<Tuser> docs=tuserDao.getAll();
		PageInfo<Tuser> pageInfo=new PageInfo<>(docs);
		return pageInfo;
	}

}
