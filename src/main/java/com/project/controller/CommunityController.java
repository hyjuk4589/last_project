package com.project.controller;

import java.awt.image.SampleModel;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("write")
	public String write() {
		return "community/write";
	}
	
	@RequestMapping("save_write")
	public String save_write(CommnuityDTO dto) {
		service.save_write(dto);
		return "redirect:list";
	}
	
	@RequestMapping("update")
	public String update(CommnuityDTO dto) {
		System.out.println(dto.getBno());
		System.out.println(dto.getContent());
		System.out.println(dto.getTitle());
		System.out.println(dto.getViewcnt());
		System.out.println(dto.getWriter());
		System.out.println(dto.getRegdate());
		service.update(dto);
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(CommnuityDTO dto) {
		service.delete(dto);
		return "redirect:list";
	}
	
	
	@RequestMapping("notice")
	public String notice() {
		return "community/notice";
	}
	
	@RequestMapping("review")
	public String review() {
		return "community/Review";
	}
	
	
}
