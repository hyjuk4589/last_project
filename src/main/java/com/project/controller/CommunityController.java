package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.service.ProjectService;

@Controller
public class CommunityController {
	@Autowired
	private ProjectService service;
	
	
	@RequestMapping("notice")
	public String notice() {
		return "community/notice";
	}
	
	
}
