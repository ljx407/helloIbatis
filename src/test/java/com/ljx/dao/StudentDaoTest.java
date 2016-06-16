package com.ljx.dao;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ljx.dao.impl.StudentDaoImpl;
import com.ljx.model.Student;

public class StudentDaoTest {
	
	private static final Logger logger = LogManager.getLogger(StudentDaoTest.class);
	
	private static StudentDao studentDaoImpl ;
	private Student student ;
	
	@BeforeClass
	public static void beforeClass() {
		studentDaoImpl = new StudentDaoImpl();
	}
	
	@Before
	public void before() {
		student = new Student() ;
		student.setName("ljx");
		student.setBirth(new Date());
		student.setScore(100);
	}
	
	@Test
	public void testAddStudent() {
		boolean addStudent = studentDaoImpl.addStudent(student);
		Assert.assertTrue(addStudent);
	}

	@Test
	public void testDeleteStudentById() {
		boolean deleteStudentById = studentDaoImpl.deleteStudentById(1);
		Assert.assertTrue(deleteStudentById);
	}

	@Test
	public void testUpdateStudent() {
		Student newStu = new Student();
		newStu.setId(2);
		newStu.setName("peggy");
		logger.info(newStu.toString());
		boolean updateStudent = studentDaoImpl.updateStudent(newStu);
		Assert.assertTrue(updateStudent);
	}

	@Test
	public void testSelectAllStudent() {
		List<Student> selectAllStudent = studentDaoImpl.selectAllStudent();
		assertThat(selectAllStudent, notNullValue());
		assertThat(selectAllStudent.size(),is(1));
	}

	@Test
	public void testSelectStudentByName() {
		List<Student> selectStudentByName = studentDaoImpl.selectStudentByName("peggy");
		assertThat(selectStudentByName,notNullValue());
		assertThat(selectStudentByName.size(),is(1));
	}

	@Test
	public void testSelectStudentById() {
		Student selectStudentById = studentDaoImpl.selectStudentById(2);
		assertThat(selectStudentById,notNullValue());
		
	}

}
