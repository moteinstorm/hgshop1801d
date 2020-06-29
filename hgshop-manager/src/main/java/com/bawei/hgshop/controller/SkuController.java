package com.bawei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bawei.hgshop.pojo.SkuVo;
import com.bawei.hgshop.pojo.Spec;
import com.bawei.hgshop.pojo.Spu;
import com.bawei.hgshop.service.SpecService;
import com.bawei.hgshop.service.SpuService;

@Controller
@RequestMapping("sku")
public class SkuController {
	
	@Reference
	SpuService spuService;
	
	@Reference
	SpecService specService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,SkuVo skuVo) {
		
		return "sku/list";
	}
	
	/**
	 * 进入添加的页面
	 * @param request
	 * @param spuId
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request,int spuId) {
		
		Spu spu = spuService.getById(spuId);
		request.setAttribute("spu", spu);
		
		List<Spec> specList = specService.listAll();
		request.setAttribute("specList", specList);
		
		return "sku/add";
	}

}
