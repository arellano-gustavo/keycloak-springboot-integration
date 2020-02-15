package com.example.productapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//mvn -e spring-boot:run

@RestController
@RequestMapping(value = "/")
public class DemoController {
	
	@GetMapping(
			value = "/products", 
			produces = "application/json; charset=utf-8")
	public String getProducts(){
		String res="{-name-:-products-}";
		return res.replace('-', '"');
	}
	@GetMapping(
			value = "/services", 
			produces = "application/json; charset=utf-8")
	public String getServices(){
		String res="{-name-:-services-}";
		return res.replace('-', '"');
	}
	@GetMapping(
			path = "/logout",
			produces = "application/json; charset=utf-8")
	public String logout(HttpServletRequest request) throws ServletException {
		String name = "tavo";
		request.logout();
		String res="{-"+name+"-:-you have been loged out-}";
		return res.replace('-', '"');
	}
	
}
