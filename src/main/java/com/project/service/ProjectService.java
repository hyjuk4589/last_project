package com.project.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.dao.BagListDAO;
import com.project.dao.UserDAO;
import com.project.dto.DressDTO;
import com.project.dto.UserDTO;

@Service
public class ProjectService {
	@Autowired
	private UserDAO userdao;
	@Autowired
	private BagListDAO listdao;
	
	public void insert(UserDTO dto) {
		userdao.insert(dto);
	}
	public void delete(String num) {
		userdao.delete(num);
	}
	public void update(UserDTO dto) {
		userdao.update(dto);
	}
	
	// 회원가입시 ID 확인
	public void idch(Model model,String id) {
		if(userdao.select(id).getId().equals(id)) {
			model.addAttribute("id_result",userdao.select(id).getId());
		}else {
			model.addAttribute("id_result","");
		}
	}
	
	// 로그인시 ID, PW 확인
	public String loginch(Model model, String id, String pw) {
		if(userdao.select(id).getId().equals(id) && userdao.select(id).getPw().equals(pw)) {
			model.addAttribute("loginch_result_id",userdao.select(id).getId());
			model.addAttribute("loginch_result_pw",userdao.select(id).getPw());
			return "redirect:index";
		}else {
			model.addAttribute("loginch_result_id","");
			model.addAttribute("loginch_result_pw","");
			return "login&join/login";
		}
	}
	
	public void body(Model model) {
		List<DressDTO> l = listdao.selectAll();
		ArrayList<String> arr= new ArrayList<String>();
		ArrayList<String> arr2= new ArrayList<String>();
		for(int i=0;i<l.size();i++) {
			arr.add("'"+l.get(i).getImg()+"'");
			arr2.add("'"+l.get(i).getProduct()+"'");
		}
		model.addAttribute("list_img",arr);
		model.addAttribute("list_product",arr2);
	}
}
