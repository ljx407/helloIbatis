package com.ljx.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ljx.dao.impl.CourceDaoImpl;
import com.ljx.model.Cource;

public class CourceDaoTest {
	
	private static final Logger logger = LogManager.getLogger(CourceDaoTest.class);
	
	private static CourceDao courceDaoImpl ;
	private Cource cource ;
	
	@BeforeClass
	public static void beforeClass() {
		courceDaoImpl = new CourceDaoImpl();
	}
	
	@Before
	public void before() {
		cource = new Cource();
		cource.setName("计算机科学与技术");
		cource.setCredit(100);
	}

	@Test
	public void testSelectById() {
		Cource cource = courceDaoImpl.selectById(1);
		assertThat(cource,notNullValue());
		assertThat(cource.getName(),is("计算机科学与技术"));
	}
	
	@Test
	public void testSelectAllByCodition() {
		Cource cource = new Cource();
		cource.setId(2);
		logger.info(cource.toString());
		
		List<Cource> selectAllByCodition = courceDaoImpl.selectAllByCodition(cource);
		assertThat(selectAllByCodition,notNullValue());
		assertThat(selectAllByCodition.size(),is(1));
	}
	
	@Test
	public void testSelectStudentById() {
		List<Cource> selectAllByCodition = courceDaoImpl.selectStudentByCourceId(2);
		assertThat(selectAllByCodition,notNullValue());
		assertThat(selectAllByCodition.size(),is(2));
	}
	
	@Test
	public void testSelectStudentByIds() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		List<Cource> selectAllByCodition = courceDaoImpl.selectStudentByIds(list);
		assertThat(selectAllByCodition,notNullValue());
	}
	
	@Test
	public void testSelectStudentByCourceIds() {
		List<Cource> list = new ArrayList<Cource>();
		Cource c1 = new Cource();
		c1.setId(1);
		
		Cource c2 = new Cource();
		c2.setId(2);
		
		list.add(c1);
		list.add(c2);
		
		List<Cource> selectAllByCodition = courceDaoImpl.selectStudentByCourceIds(list);
		assertThat(selectAllByCodition,notNullValue());
	}
	
	@Test
	public void selectStudentByCourceIdsWithMap() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", "2");
		map.put("name", "大学英语");
		
		List<Cource> selectAllByCodition = courceDaoImpl.selectStudentByCourceIdsWithMap(map);
		assertThat(selectAllByCodition,notNullValue());
	}
	
	@Test
	public void testInsert() {
		Cource c = new Cource() ;
		c.setName("高数");
		c.setCredit(99);
		
		boolean b = courceDaoImpl.insert(c);
		
		logger.info(c);
		assertThat(b,is(true));
	}
	
	@Test
	public void testInsertDynamic() {
		Cource c = new Cource() ;
		c.setName("高数");
		c.setCredit(99);
		
		boolean b = courceDaoImpl.insertDynamic(c);
		
		logger.info(c);
		assertThat(b,is(true));
	}
	
	@Test
	public void insertBatch() {
		Cource c = new Cource() ;
		c.setName("物理");
		c.setCredit(99);
		
		Cource c1 = new Cource() ;
		c1.setName("化学");
		c1.setCredit(99);
		
		List<Cource> l = new ArrayList<Cource>();
		l.add(c1);
		l.add(c);
		
		boolean b = courceDaoImpl.insertBatch(l);
		
		logger.info(c);
		assertThat(b,is(true));
	}
	
	@Test
	public void testDelete() {
		boolean b = courceDaoImpl.delete(9);
		assertThat(b,is(true));
	}
	
	@Test
	public void testUpdateById() {
		Cource c = new Cource() ;
		c.setName("大学物理");
		c.setCredit(99);
		c.setId(11);
		boolean result = courceDaoImpl.updateById(c);
		assertThat(result,is(true));
	}

}
