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
import com.ljx.dao.StudentDao;
import com.ljx.model.Student;

public class StudentDaoImpl implements StudentDao {
	
	private static SqlMapClient sqlMapClient=null;
	
	private static final Logger logger = LogManager.getLogger(StudentDaoImpl.class);
	
	// 读取配置文件
	static {
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
	}

	public boolean addStudent(Student student) {
		Object object = null;
		boolean flag = false;
		try {
			object = sqlMapClient.insert("addStudent", student);
			logger.info("添加学生信息的返回值：" + object);
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteStudentById(int id) {
		boolean flag = false;
		Object object = null;
		try {
			object = sqlMapClient.delete("deleteStudentById", id);
			logger.info("删除学生信息的返回值：" + object + "，这里返回的是影响的行数");
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateStudent(Student student) {
		boolean flag = false;
		Object object = false;
		try {
			object = sqlMapClient.update("updateStudent", student);
			logger.info("更新学生信息的返回值：" + object + "，返回影响的行数");
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<Student> selectAllStudent() {
		List<Student> students = null;
		try {
			students = sqlMapClient.queryForList("selectAllStudent");
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		}
		return students;
	}

	@SuppressWarnings("unchecked")
	public List<Student> selectStudentByName(String name) {
		List<Student> students = null;
		try {
			students = sqlMapClient.queryForList("selectStudentByName", name);
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		}
		return students;
	}

	public Student selectStudentById(int id) {
		Student student = null;
		try {
			student = (Student) sqlMapClient.queryForObject("selectStudentById", id);
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		}
		return student;
	}
}
