package com.shopmilk.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopmilk.test;
import com.shopmilk.entities.Order;
import com.shopmilk.entities.OrderDetail;
import com.shopmilk.entities.OrderDetailId;
import com.shopmilk.entities.Product;
import com.shopmilk.service.CategoryService;
import com.shopmilk.service.OrderDetailService;
import com.shopmilk.service.OrderService;
import com.shopmilk.service.ProductService;

@Controller
public class mainController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailService detailService;

	@RequestMapping("/home")
	public String index(ModelMap model) {
		model.addAttribute("categories", categoryService.findAll());
		// model.addAttribute("bestSeller", productService.getByBestSeller(4));
		model.addAttribute("mostViews", productService.getByMostViews(8));
		return "index";
	}

	@RequestMapping("/allProduct")
	public String product(ModelMap model) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("products", productService.findAll());
		return "product";
	}

	@GetMapping("/search")
	public String search(ModelMap model, @RequestParam("searchValue") String value) {
		model.addAttribute("categories", categoryService.findAll());
		if (productService.search(value).size() > 0) {
			model.addAttribute("products", productService.search(value));
		}
		return "product";
	}

	@GetMapping("/searchProduct")
	public String productFilter(ModelMap model, HttpServletRequest request) {

		String priceRange = request.getParameter("priceRange");
		String categoryID = request.getParameter("cateID");

		int id = 0;
		if (categoryID != null) {
			id = Integer.parseInt(categoryID);
		}
		model.addAttribute("categoryID", categoryID);
		model.addAttribute("categories", categoryService.findAll());

		long[] price = null;
		if (priceRange != null) {
			price = test.getPrice(priceRange);
		}
		try {
			if (categoryID == null) {
				model.addAttribute("priceValue1", price[0]);
				model.addAttribute("priceValue2", price[1]);
				if (productService.SearchByPriceRange(price[0], price[1]).size() > 0) {
					model.addAttribute("products", productService.SearchByPriceRange(price[0], price[1]));
				}
			} else if (priceRange == null) {
				if (productService.searchByCateID(id).size() > 0) {
					model.addAttribute("products", productService.searchByCateID(id));
				}
			} else if (categoryID != null && priceRange != null) {
				model.addAttribute("priceValue1", price[0]);
				model.addAttribute("priceValue2", price[1]);
				if (productService.SearchByCateAndPriceRange(id, price[0], price[1]).size() > 0) {
					model.addAttribute("products", productService.SearchByCateAndPriceRange(id, price[0], price[1]));
				}
			}
		} catch (NullPointerException e) {
			System.out.println(e.toString());
		}
		return "product";
	}

	@GetMapping("/productDetail")
	public String productDetail(ModelMap model, @RequestParam("cateID") int cateID,
			@RequestParam("productID") int productID) {
		model.addAttribute("product", productService.findOne(productID));
		model.addAttribute("relatedProducts", productService.searchByCateID(cateID));
		return "productDetail";
	}

	@GetMapping("/order")
	public String testLoad(ModelMap model) {
		model.addAttribute("orderForm", new Order());
		model.addAttribute("orderDetailForm", new OrderDetail());
		return "checkout";
	}

	@PostMapping("/order") 
	public String addOrder(@ModelAttribute("orderForm") Order order,
			ModelMap model, HttpServletRequest request) {
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		order.setDate(new Date());
		System.out.println("Tên: " + order.getCustomerName() + " Địa chỉ: " + order.getAddress());
		orderService.save(order);
		
		int noProduct = Integer.parseInt(request.getParameter("noProductInCart"));
		for (int i = 1; i <= noProduct; i++) {
			Product product = productService.findByName(request.getParameter("productName" + i));
			int noProductInCart = Integer.parseInt(request.getParameter("productQuantity" + i));
			
			int noProductInStock = product.getQuantity();
			if(noProductInStock > noProductInCart || noProductInStock == noProductInCart) {
				product.setQuantity(product.getQuantity() - noProductInCart);
				productService.update(product);
			}
			
			long total = product.getPrice() * noProductInCart;
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setId(new OrderDetailId(order.getId(), product.getId()));
			orderDetail.setOrder(order);
			orderDetail.setProduct(product);
			orderDetail.setQuantity(noProductInCart);
			orderDetail.setAmount(total);
			detailService.save(orderDetail);
		}
		return "redirect:/home";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/khuyenmai")
	public String khuyenmai() {
		return "contact2";
	}
	
	@GetMapping("/dinhduong")
	public String dinhduong() {
		return "contact3";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
