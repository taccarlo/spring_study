package com.myphotos.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The controller annotation indicates that a particular class serves the role of controller.
 * It is used to mark a class as a web request handler.
 */

@Controller
public class AdminController {

	/**
	 * RequestMapping is used to map to the Spring MVC controller method.
	 */
	
	@RequestMapping("/admin")
	public String index() {
		return "admin";
	}
}
