package com.example.demo.hello.controller;

import com.example.demo.api.NewStudent;
import com.example.demo.api.StudentUpdate;
import com.example.demo.hello.domain.Student;

import org.springframework.http.MediaType;

import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@RequestMapping("/rest/students")
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
		method = RequestMethod.HEAD
	)
	public void initialize()
	{
		createStudents();
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @return
	 */
	@RequestMapping(
		value = "/student/{id}",
		method = RequestMethod.GET,
		produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public Student getStudentById(@PathVariable
		Long id)
	{
		Student result = null;
		if ((id != null) && studentMap.containsKey(id))
		{
			result = studentMap.get(id);
		}

		return result;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	@RequestMapping(
		value = "/all",
		method = RequestMethod.GET,
		produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public List<Student> all()
	{
		return studentMap.entrySet().stream().map(student -> student.getValue()).collect(Collectors.toList());
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   subject
	 * @return
	 */
	@RequestMapping(
		value = "/subject/{subject}",
		method = RequestMethod.GET,
		produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public List<Student> filterById(@PathVariable
		String subject)
	{
		final String subjectFilter = StringUtils.capitalize(subject.toLowerCase());

		return studentMap.entrySet().stream().filter(s -> s.getValue().getSubject().equals(subjectFilter)).map(
			filtered -> filtered.getValue()).collect(Collectors.toList());
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   student
	 * @return
	 */
	@RequestMapping(
		value = "/add",
		method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public String addStudent(@RequestBody
		@Valid
		NewStudent student)
	{
		String message = "New student created.";
		if (studentMap.containsKey(student.getId()))
		{
			message = "Student ID " + student.getId() + " already exists.";
		}
		else
		{
			Student s = new Student.Builder().addId(student.getId()).addName(student.getName()).addSubject(student
					.getSubject()).build();
			studentMap.put(s.getId(), s);
		}

		return message;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @param   student
	 * @return
	 */
	@RequestMapping(
		value = "/update/{id}",
		method = RequestMethod.PUT,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public String updateStudent(@NotNull
		@PathVariable
		Long id, @RequestBody
		@Valid
		StudentUpdate student)
	{
		String message = "Student not updated.";
		if (studentMap.containsKey(id))
		{
			Student s = studentMap.get(id);
			s.setName(student.getName());
			s.setSubject(student.getSubject());
			studentMap.put(s.getId(), s);
			message = "Student with ID " + id + " updated.";
		}

		return message;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @return
	 */
	@RequestMapping(
		value = "/delete/{id}",
		method = RequestMethod.DELETE
	)
	public String deleteStudent(@NotNull
		@PathVariable
		Long id)
	{
		String message = "Student with ID " + id + " doesn't exist.";
		if (studentMap.containsKey(id))
		{
			studentMap.remove(id);
			message = "Student with ID " + id + " deleted.";
		}

		return message;
	}
	
	/** DOCUMENT ME! */
	@RequestMapping
	private void createStudents()
	{
		Student s1 = new Student.Builder().addId(1).addName("Danna").addSubject("English").build();
		studentMap.put(s1.getId(), s1);
		Student s2 = new Student.Builder().addId(2).addName("Lei").addSubject("Math").build();
		studentMap.put(s2.getId(), s2);
		Student s3 = new Student.Builder().addId(3).addName("Daniel").addSubject("English").build();
		studentMap.put(s3.getId(), s3);
	}
}
