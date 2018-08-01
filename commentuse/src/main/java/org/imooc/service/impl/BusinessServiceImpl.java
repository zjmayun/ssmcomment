package org.imooc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.imooc.bean.Business;
import org.imooc.bean.Page;
import org.imooc.constant.CategoryConst;
import org.imooc.dao.BusinessDao;
import org.imooc.dto.BusinessDto;
import org.imooc.dto.BusinessListDto;
import org.imooc.service.BusinessService;
import org.imooc.util.CommonUtil;
import org.imooc.util.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Resource
	private BusinessDao businessDao;

	@Value("${businessImage.savePath}")
	private String savePath;

	@Value("${businessImage.url}")
	private String url;

	public BusinessDto getById(Long id) {
		BusinessDto result = new BusinessDto();
		Business business = businessDao.selectById(id);
		BeanUtils.copyProperties(business, result);
		result.setImg(url + business.getImgFileName());
		
		result.setStar(this.getStar(business));
		
		return result;
	}

	

	public BusinessListDto searchByPageForApi(BusinessDto businessDto) {
		BusinessListDto businessListDto=new BusinessListDto();
		Business business=new Business();
		BeanUtils.copyProperties(businessDto, business);
		List<BusinessDto> listDto=new ArrayList<BusinessDto>();
		List<Business> list=businessDao.selectLikeByPage(business);
		for(int i=0;i<list.size();i++) {
			BusinessDto b=new BusinessDto();
			Business bus=list.get(i);
			BeanUtils.copyProperties(bus, b);
			b.setImg(url+b.getImgFileName());
			b.setMumber(0);
			b.setStar(0);
			listDto.add(b);
		}
		if(listDto.size()>0) {
			businessListDto.setHasMore(true);
		}else {
			businessListDto.setHasMore(false);
		}
		businessListDto.setData(listDto);
		return businessListDto;
	}

	public boolean add(BusinessDto businessDto) {
		Business business = new Business();
		BeanUtils.copyProperties(businessDto, business);
		
		if (businessDto.getImgFile() != null && businessDto.getImgFile().getSize() > 0) {
			try {
				String fileName = FileUtil.save(businessDto.getImgFile(), savePath);
				business.setImgFileName(fileName);
				// 默认已售数量为0
				business.setNumber(0);
				// 默认评论总次数为0
				business.setCommentTotalNum(0L);
				// 默认评论星星总数为0
				business.setStarTotalNum(0L);
				businessDao.insert(business);
				return true;
			} catch (IOException e) {
				// TODO 需要添加日志
				return false;
			}
		} else {
			return false;
		}
	}
	
	private int getStar(Business business) {
		if(business.getStarTotalNum() != null && business.getCommentTotalNum() != null && business.getCommentTotalNum() != 0) {
			return (int)(business.getStarTotalNum() / business.getCommentTotalNum());
		} else {
			return 0;
		}
	}

	public int deletById(Long id) {
		int i=businessDao.deleteById(id);
		return i;
	}

	public int modify(BusinessDto businessDto) {
		Business business=new Business();
		BeanUtils.copyProperties(businessDto, business);
		int i=businessDao.update(business);
		return i;
	}
<<<<<<< HEAD



	public List<Business> searchByPage(Business business) {
		List<Business> list=businessDao.selectByPage(business);
		return list;
	}
=======
>>>>>>> e3d42c8acb71e3ded5ab503596e3da5898053a8a
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
