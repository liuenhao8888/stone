package com.stone.cart.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.BusinessException;
import com.stone.cart.model.Cart;
import com.stone.cart.model.CartItem;
import com.stone.product.mapper.ProductMapper;
import com.stone.product.model.Product;

@Controller
public class CartController extends BaseController {

	protected static final Logger log = Logger.getLogger(CartController.class);

	@RequestMapping(value = "/cart_add")
	public ModelAndView add(HttpServletResponse rps, HttpServletRequest rqs,CartItem item) throws BusinessException, IOException {
		ModelAndView mav = new ModelAndView();
		Cart cart  = (Cart) this.getCurrentCart(rqs);
		if (cart == null) cart = new Cart();
		ProductMapper pm = this.getMybatisBaseService().getMapper(ProductMapper.class);
		Product product = pm.selectByPrimaryKey(item.getProduct().getId());
		item.setProduct(product);
		cart.add(item);
		this.setCurrentCart(cart,rqs,rps);
		mav.addObject("cart", cart);
		mav.setViewName("cart");
		return mav;
	}
	
	
	@RequestMapping(value = "/cart_list")
	public ModelAndView list(HttpServletResponse rps, HttpServletRequest rqs,CartItem item) throws BusinessException, IOException {
		ModelAndView mav = new ModelAndView();
		Cart cart  = (Cart) this.getCurrentCart(rqs);
		mav.addObject("cart", cart);
		mav.setViewName("cart");
		return mav;
	}
	

	@RequestMapping(value = "/cart_delete")
	public String delete(HttpServletResponse rps, HttpServletRequest rqs,
			CartItem item, Product p) throws BusinessException, IOException {

		HttpSession session = rqs.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			return "";
		}
		cart.deleteItemById(p.getId());

		rps.sendRedirect("list.do?cid=");
		return null;
	}

	@RequestMapping(value = "/cart_update")
	public String update(HttpServletResponse rps, HttpServletRequest rqs,
			CartItem item, Product p) throws BusinessException, IOException {

		HttpSession session = rqs.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			return "";
		}

		rps.sendRedirect("list.do?cid=");
		return null;
	}

}
