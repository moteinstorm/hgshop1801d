package com.bawei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bawei.hgshop.pojo.Sku;
import com.bawei.hgshop.pojo.SkuVo;
import com.bawei.hgshop.pojo.Spec;
import com.bawei.hgshop.pojo.SpecOption;
import com.bawei.hgshop.pojo.Spu;
import com.bawei.hgshop.service.SkuService;
import com.bawei.hgshop.service.SpecService;
import com.bawei.hgshop.service.SpuService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("sku")
public class SkuController {
	
	@Reference
	SpuService spuService;
	
	@Reference
	SpecService specService;
	
	
	@Reference
	SkuService skuService;
	
	@Autowired
	HgFileUtils fileUtils;
	
	
	
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,SkuVo skuVo) {
		
		PageInfo<Sku> pageInfo = skuService.list(skuVo);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("skuVo", skuVo);
		
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
	
	/**
	 * 添加sku
	 * @param request
	 * @param sku
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request,Sku sku,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("cartThumbnailFile") MultipartFile cartThumbnailFile ) {
		List<SpecOption> list = sku.getOptions();
		//数据清零一下
		 for (int i = list.size()-1; i >=0; i--) {
			SpecOption option = list.get(i);
			if(null == option.getSpecId() || 0==option.getSpecId()) {
				list.remove(i);
			}
		}
		// 处理图片
		 sku.setImage(fileUtils.upload(imageFile)); 
		 sku.setCartThumbnail(fileUtils.upload(cartThumbnailFile)); 
		 
		return skuService.add(sku)>0?"ok":"failed";
	}
	
	/**
	 * 获取一个规格的所有属性
	 * @param specId
	 * @return
	 */
	@RequestMapping("getSpecOptions")
	@ResponseBody
	public List<SpecOption> getOptions(int specId){
		Spec spec = specService.getById(specId);
		if(spec==null)
			return null;
		return spec.getOptions();
	}

}
