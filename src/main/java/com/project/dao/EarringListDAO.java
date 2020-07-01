package com.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dto.EarringListDTO;

@Repository
public class EarringListDAO {
	
	@Autowired private SqlSession sqlSession;
	public static final String namepasce="com.project.mybatis.myMapper";
	public List<EarringListDTO> selectAll() {
		return sqlSession.selectList(namepasce+".easelectAll_List");
	}
}
