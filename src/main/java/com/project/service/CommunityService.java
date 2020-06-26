package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dto.CommnuityDTO;


public interface CommunityService {
	public List<CommnuityDTO> listAll();
}
