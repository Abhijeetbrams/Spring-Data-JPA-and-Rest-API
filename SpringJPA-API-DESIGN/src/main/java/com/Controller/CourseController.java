package com.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Bonus;
import com.Entity.Course;
import com.Entity.Respose;
import com.Service.CourseService;
import com.amazonaws.xray.spring.aop.XRayEnabled;
//import com.POJO.Department;
@RestController
@XRayEnabled
@RequestMapping("/api")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/course")
	public List<Course> findAll()
	{
	   
		return  courseService.findAll();
		
	}
	
	@GetMapping("/course/{id}")
	public Course findById(@PathVariable("id") int theId)
	{
		
		
		return courseService.findById(theId);
	
	}
	
	
	
	@PostMapping("/course")
	public ResponseEntity<Respose> save(@RequestBody Course theCourse)
	{
		theCourse.setId(0);;
		courseService.save(theCourse);
		Respose response = new Respose();
		response.setCode(HttpStatus.CREATED.toString());
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		response.setDate(dtf.format(now));
		response.setMessage("Succesfully Inserted");
		
		return new ResponseEntity(response,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Respose> delete(@PathVariable("id") int theId)
	{
		courseService.deleteById(theId);
		Respose response = new Respose();
		response.setCode(HttpStatus.ACCEPTED.toString());
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		response.setDate(dtf.format(now));
		response.setMessage("Succesfully Deleted");
		
		return new ResponseEntity(response,HttpStatus.ACCEPTED);
	}
	
/*
	@GetMapping("/add")
	public String addDepartment(Model theModel)
	{
		theModel.addAttribute("departments", new com.POJO.Department());
		return "AddDepartment";
	}
	*/
}
