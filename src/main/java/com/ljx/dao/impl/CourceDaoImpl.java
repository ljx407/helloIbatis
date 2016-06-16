package com.ljx.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

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

	@Override
	public Cource selectById(int id) {
		Cource cource = null ;
		try {
			@SuppressWarnings("unchecked")
			List<Cource> queryForList = sqlMapClient.queryForList("selectById", id);
			if(queryForList != null && queryForList.size() > 0) {
				cource = queryForList.get(0);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		}
		return cource;
	}

}
