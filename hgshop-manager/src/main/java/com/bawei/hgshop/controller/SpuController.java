package com.bawei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bawei.hgshop.pojo.Brand;
import com.bawei.hgshop.pojo.Spu;
import com.bawei.hgshop.pojo.SpuVo;
import com.bawei.hgshop.service.BrandService;
import com.bawei.hgshop.service.SpuService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("spu")
public class SpuController {
	
	@Reference
	SpuService spuService;
	
	//品牌
	@Reference
	BrandService brandService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,SpuVo spuvo) {
		
		System.err.println("spu vo is " + spuvo);
		spuvo.setPageSize(20);
		PageInfo<Spu> pageInfo = spuService.list(spuvo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spuvo", spuvo);
		// 得到所有的品牌
		List<Brand> brandList = brandService.list();
		request.setAttribute("brandList", brandList);
		//pageInfo.getPages()
		
		return "spu/list";
	}
	
	
	@RequestMapping("toadd")
	public String toadd(HttpServletRequest request) {
		
		// 得到所有的品牌
		List<Brand> brandList = brandService.list();
		request.setAttribute("brandList", brandList);
		
		
				
		return "spu/add";
	}
}
