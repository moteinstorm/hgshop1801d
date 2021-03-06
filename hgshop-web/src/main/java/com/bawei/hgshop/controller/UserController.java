package com.bawei.hgshop.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.hgshop.common.MsgData;
import com.bawei.hgshop.pojo.Cart;
import com.bawei.hgshop.pojo.OrderDetail;
import com.bawei.hgshop.pojo.Orderz;
import com.bawei.hgshop.pojo.User;
import com.bawei.hgshop.service.CartService;
import com.bawei.hgshop.service.SecuritService;
import com.bawei.hgshop.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("user")
public class UserController {

		@Reference
		UserService userService;
		
		@Reference 
		CartService cartService;
		
		@Reference 
		SecuritService ss;
	
		/**
		 * 去登陆页面
		 * @param request
		 * @return
		 */
		@GetMapping("login")
		public String toLogin(HttpServletRequest request) {
			return "user/login";
		}	
		
		@PostMapping("login")
		public String toLogin(HttpServletRequest request,User user) {
			
			User loginUser = userService.login(user);
			if(loginUser == null)
				return "user/login";
			
			//登录成功
			request.getSession().setAttribute("USERSESSION", loginUser);
			return "redirect:home";
		}	
		
		@RequestMapping("checkExist")
		@ResponseBody
		public boolean checkExist(String username) {
			return null==userService.getUserByName(username);	
		}
		
		/**
		 * 去登陆页面
		 * @param request
		 * @return
		 */
		@GetMapping("register")
		public String register(HttpServletRequest request) {
			return "user/register";
		}	
		
		@PostMapping("register")
		public String register(HttpServletRequest request,User user) {
			
			User reguser = userService.register(user);
			if(reguser!=null)
				return "redirect:login";
			
			return "user/register";
		}	
		
		@RequestMapping("home")
		public String home(HttpServletRequest request) {
			User loginUser  = (User)request.getSession().getAttribute("USERSESSION");
			if(loginUser==null) {
				return "redirect:login";
			}
			return "user/home";
		}
		
		/**
		 * 加入购物车
		 * @param request
		 * @param cart
		 * @return
		 */
		@RequestMapping("addcart")
		@ResponseBody
		public MsgData  addCart(HttpServletRequest request,Cart cart) {
			
			User loginUser  = (User)request.getSession().getAttribute("USERSESSION");
			if(loginUser==null) {
				return new MsgData(1,"对不起，您尚未登录");
			}
			//设置用户id
			cart.setUid(loginUser.getUid());
			int result = cartService.add(cart);
			
			return result>0? new MsgData("保存成功"): new MsgData(2, "加入失败，请稍后再试");
			
		}
		
		/**
		 *  订单的列表
		 * @param request
		 * @return
		 */
		@RequestMapping("orderlist")
		public String orderlist(HttpServletRequest  request, int page) {
			// 获取当前的用户
			User loginUser  = (User)request.getSession().getAttribute("USERSESSION");
			PageInfo<Orderz> pageInfo = userService.listOrderz(loginUser.getUid(), page);
			pageInfo.getList().forEach(x->{System.err.println("x is " + x);});
			request.setAttribute("pageInfo", pageInfo);
			return "user/orderlist";
		}
		
		/**
		 *  订单的列表
		 * @param request
		 * oid 订单id
		 * @return
		 */
		@RequestMapping("orderDetails")
		public String orderDetail(HttpServletRequest  request, int oid) {
			// 获取当前的用户
			User loginUser  = (User)request.getSession().getAttribute("USERSESSION");
			List<OrderDetail> orderDetails = userService.listOrderDetail(oid);
			request.setAttribute("orderDetails", orderDetails);
			return "user/detaillist";
		}
		
		
		/**
		 * 进入购物车列表页面
		 * @param request
		 * @return
		 */
		@RequestMapping("cartlist")
		public String carlist(HttpServletRequest  request) {
			// 获取当前的用户
			User loginUser  = (User)request.getSession().getAttribute("USERSESSION");
			//购物车列表
			List<Cart> list = cartService.list(loginUser.getUid());
			request.setAttribute("cartList", list);
			return "user/cartlist";
		}
		
		@RequestMapping("createOrder")
		@ResponseBody
		public MsgData createOrder(HttpServletRequest  request,String address, @RequestParam("cardIds[]") int[] cartIds) {
			
			// 获取当前的用户
			User loginUser  = (User)request.getSession().getAttribute("USERSESSION");
			if(loginUser==null) {
				return new MsgData(1,"对不起，您尚未登录");
			}
			
			int result = cartService.createOrder(cartIds,address,loginUser.getUid());
			return result>0?new MsgData("ok"):new  MsgData(2,"下单失败，请稍后再试");
			
						
		}
		
		@RequestMapping("getkey")
		@ResponseBody
		public MsgData getKey(HttpServletRequest request,HttpServletResponse resspones) {
			String get16RandStr = ss.get16RandStr();
			
			//存入cookie
			Cookie cookie = new Cookie("key", get16RandStr);
			resspones.addCookie(cookie);
			
			return new MsgData(get16RandStr);
			
		}
}
