package com.example.demo.hello.controller;

import com.example.demo.hello.domain.Student;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@RequestMapping("/rest/student")
@RestController
public class StudentController
{
	//~ Instance fields --------------------------
	/**  */
	Map<Long, Student> studentMap = new HashMap<>();
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	@RequestMapping(
		value = "/initialize",
		method = RequestMethod.GET
	)
	public String initialize()
	{
		createStudents();

		return "Students created.";
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @return
	 */
	@RequestMapping(
		value = "/getStudent/{id}",
		method = RequestMethod.GET,
		produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public Student getStudent(@PathVariable
		Long id)
	{
		return studentMap.get(id);
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   subject
	 * @return
	 */
	@RequestMapping(
		value = "/filterBySubject/{subject}",
		method = RequestMethod.GET,
		produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public List<Student> filterById(@PathVariable
		String subject)
	{
		return studentMap.entrySet().stream().filter(s -> s.getValue().getSubject().equals(subject)).map();
	}
	
	/** DOCUMENT ME! */
	private void createStudents()
	{
		Student s1 = new Student.Builder().addId(1).addName("Danna").addSubject("English").build();
		studentMap.put(s1.getId(), s1);
		Student s2 = new Student.Builder().addId(2).addName("Lei").addSubject("Math").build();
		studentMap.put(s2.getId(), s2);
	}
}
