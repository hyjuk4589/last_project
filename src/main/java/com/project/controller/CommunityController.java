package com.project.controller;

import java.awt.image.SampleModel;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.CommnuityDTO;
import com.project.service.CommunityService;
import com.project.service.ProjectService;

@Controller
public class CommunityController {
	
	@Inject
	CommunityService service;
	
	@RequestMapping("list")
	public ModelAndView list() {
		List<CommnuityDTO> list = service.listAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("community/list");
		return mav;

	}
	
	@RequestMapping("view")
	public String view(CommnuityDTO dto, Model model) {
		service.count(dto);
		service.view(dto,model);
		
		return "community/view";
	}
	
	
	@RequestMapping("notice")
	public String notice() {
		return "community/notice";
	}
	
	@RequestMapping("review")
	public String review() {
		return "community/Review";
	}
	
//	@RequestMapping("qa")
//	public String Qa() {
//		return "community/Qa";
//	}
	
	
}
