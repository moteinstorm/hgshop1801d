package com.bawei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.hgshop.pojo.Category;
import com.bawei.hgshop.pojo.Spu;
import com.bawei.hgshop.pojo.SpuVo;
import com.bawei.hgshop.service.CategoryService;
import com.bawei.hgshop.service.SpuService;
import com.github.pagehelper.PageInfo;

/**
 * 首页相关
 * @author 45466
 *
 */
@Controller
public class IndexController {
	
	@Reference
	SpuService spuService;
	
	@Reference
	CategoryService catService;
	
	
	@RequestMapping({"/","index"})
	public String index(HttpServletRequest request,SpuVo spuVo) {
		spuVo.setPageSize(16);
		PageInfo<Spu> pageInfo = spuService.list(spuVo);
		//pageInfo.getPageNum()
		//pageInfo.getPages()
		request.setAttribute("pageInfo", pageInfo);
		
		return "index";
	}
	
	@RequestMapping("catData")
	@ResponseBody
	public List<Category> getData(){
		// 获取到所有分类的数据
		 List<Category> categories = catService.list(0);
		 return categories;
		
	}
}
