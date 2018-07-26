package org.imooc.service;

import java.util.List;

import org.imooc.bean.Tuser;

import com.github.pagehelper.PageInfo;

public interface TuserService {
	PageInfo<Tuser> getAll(int currentPage,int pageSize);
}
