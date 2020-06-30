package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dto.UserDTO;
import com.project.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService service;
	
	@RequestMapping("index")
	public String index_run() {
		return "default/index";
	}
	
	@RequestMapping("login")
	public String login(){
		return "login&join/login";
	}
	@RequestMapping("loginchk")
	public String loginch(Model model, @RequestParam String id, @RequestParam String pw) {
		return service.loginch(model,id,pw);
	}
	@RequestMapping("joinok")
	public String joinok(UserDTO dto) {
		service.insert(dto);
		return "redirect:index";
	}
	@RequestMapping("join")
	public String join() {
		return "login&join/join";
	}
	@RequestMapping("idch")
	public String idch(Model model, @RequestParam String id) {
		service.idch(model,id);
		return "login&join/join";
	}
	
	@RequestMapping("design")
	public String design() {
		return "design/design";
	}
	@RequestMapping("tip")
	public String tip() {
		return "design/tip";
	}
	
	@RequestMapping("cart")
	public String cart() {
		return "shop/cart";
	}
	
	@RequestMapping("dress")
	public String body(Model model) {
		service.dress(model);
		return "default/dress";
	}
	@RequestMapping("bag")
	public String bag(Model model) {
		service.bag(model);
		return "default/bag";
	}
	@RequestMapping("earring")
	public String earring(Model model) {
		service.earring(model);
		return "default/earring";
	}
}
