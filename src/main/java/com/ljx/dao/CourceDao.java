package com.ljx.dao;

import java.util.List;
import java.util.Map;

import com.ljx.model.Cource;

public interface CourceDao {
	public Cource selectById(int id);
	
	public List<Cource> selectAllByCodition(Cource cource) ;
	
	public List<Cource> selectStudentByCourceId(int id) ;
	
	public List<Cource> selectStudentByIds(List<Integer> cIds) ;
	
	public List<Cource> selectStudentByCourceIds(List<Cource> cIds) ;
	
	public List<Cource> selectStudentByCourceIdsWithMap(Map<String,String> paraMap) ;
	
	public boolean insertBatch(List<Cource> list) ;
	
	public boolean insertDynamic(Cource c) ;
	
	public boolean insert(Cource c) ;
	
	public boolean delete(int id);
	
	public boolean updateById(Cource c);
	
}
