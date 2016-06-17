package com.ljx.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ljx.dao.CourceDao;
import com.ljx.model.Cource;

public class CourceDaoImpl implements CourceDao {
	
	private static SqlMapClient sqlMapClient ;
	private static final Logger logger = LogManager.getLogger(CourceDaoImpl.class);
	
	static {
		Reader reader = null ;
		try {
			reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
		
	}
	
	/**
	 * 根据课程id查询课程信息
	 */
	@Override
	public Cource selectById(int id) {
		Cource cource = null ;
		try {
			@SuppressWarnings("unchecked")
			List<Cource> queryForList = sqlMapClient.queryForList("cource.selectById", id);
			if(queryForList != null && queryForList.size() > 0) {
				cource = queryForList.get(0);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		}
		return cource;
	}
	
	/**
	 * 查询符合条件的课程
	 */
	@Override
	public List<Cource> selectAllByCodition(Cource cource) {
		List<Cource> queryForList = null ;
		try {
			queryForList = sqlMapClient.queryForList("cource.selectAllByCodition", cource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return queryForList;
	}

	/**
	 * 查询选修了某门课程的所有学生
	 */
	@Override
	public List<Cource> selectStudentByCourceId(int id) {
		List<Cource> queryForList = null ;
		try {
			queryForList = sqlMapClient.queryForList("cource.selectStudentByCourceId", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return queryForList;
	}

	@Override
	public List<Cource> selectStudentByIds(List<Integer> cIds) {
		List<Cource> queryForList = null ;
		try {
			queryForList = sqlMapClient.queryForList("cource.selectStudentByIds", cIds);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return queryForList;
	}

	@Override
	public List<Cource> selectStudentByCourceIds(List<Cource> cIds) {
		List<Cource> queryForList = null ;
		try {
			queryForList = sqlMapClient.queryForList("cource.selectStudentByCourceIds", cIds);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return queryForList;
	}

	@Override
	public List<Cource> selectStudentByCourceIdsWithMap(Map<String, String> paraMap) {
		List<Cource> queryForList = null ;
		try {
			queryForList = sqlMapClient.queryForList("cource.selectStudentByCourceIdsWithMap", paraMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return queryForList;
	}
	
	
	

}
