package com.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.dto.CommnuityDTO;

@Repository
public class CommnuityDAO {
	@Inject
	private SqlSession sqlSession;
	
	public static final String namepasce="com.project.mybatis.myMapper";
	
	public List<CommnuityDTO> listAll() {
		return sqlSession.selectList(namepasce+".selectAll_Commnuity");
	}
}
