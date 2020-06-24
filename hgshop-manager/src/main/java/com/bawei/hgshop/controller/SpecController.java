package com.bawei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.hgshop.pojo.Spec;
import com.bawei.hgshop.pojo.SpecOption;
import com.bawei.hgshop.service.SpecService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	SpecService specService;
	
	/**
	 * 接收添加的请求，调用服务
	 * @param spec
	 * @return
	 */
	@PostMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request, Spec spec) {
		
		System.out.println("spec is " + spec);
		
		List<SpecOption> options = spec.getOptions();
		// 数据进行清洗
		for (int i = options.size()-1; i >=0; i--) {
			SpecOption option = options.get(i);
			if(option.getOptionName()==null || "".equals(option.getOptionName())) {
				options.remove(i);
			}
		}
		return specService.add(spec)>0?"ok":"failed";
	}
	
	
	/**
	 *  进入到添加页面
	 * @param spec
	 * @return
	 */
	@GetMapping("add")
	public String add() {
		return "spec/add";
	}
	
	/**
	 * 列表
	 * @param request
	 * @param name
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "1") int page) {
		PageInfo<Spec> pageInfo = specService.list(page, 5, new Spec(name));
		request.setAttribute("pageInfo", pageInfo);
		return "spec/list";
	}

}
