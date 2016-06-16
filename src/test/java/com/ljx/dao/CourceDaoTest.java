package com.ljx.dao;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ljx.dao.impl.CourceDaoImpl;
import com.ljx.model.Cource;

public class CourceDaoTest {
	
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

}
