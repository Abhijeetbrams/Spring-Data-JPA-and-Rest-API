package com.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Respose;
import com.Entity.Worker;
import com.Service.WorkerService;
import com.amazonaws.xray.spring.aop.XRayEnabled;
//import com.POJO.Department;
@RestController
@XRayEnabled
@RequestMapping("/api")
public class WorkerController {

	@Autowired
	private WorkerService workerService;
	
	@GetMapping("/workers")
	public List<Worker> findAll()
	{
	 
		
		return  workerService.findAll();
		
	}
	
	@GetMapping("/workers/{id}")
	public Worker findById(@PathVariable("id") int theId)
	{
		
		System.out.println(workerService.findById(theId));
		return workerService.findById(theId);
	
	}
	
	
	
	@PostMapping("/workers")
	public ResponseEntity<Respose> save(@RequestBody Worker theWorker)
	{
		theWorker.setWorkerId(0);
		workerService.save(theWorker);
		Respose response = new Respose();
		response.setCode(HttpStatus.CREATED.toString());
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		response.setDate(dtf.format(now));
		response.setMessage("Succesfully Inserted");
		
		return new ResponseEntity(response,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/workers/{id}")
	public ResponseEntity<Respose> delete(@PathVariable("id") int theId)
	{
		workerService.deleteById(theId);
		Respose response = new Respose();
		response.setCode(HttpStatus.ACCEPTED.toString());
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		response.setDate(dtf.format(now));
		response.setMessage("Succesfully Deleted");
		
		return new ResponseEntity(response,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/workers/maxSal")
	public List<Object> findMaxSalByDepartment()
	{
	 
		
		return  workerService.findMaxSalByDepartment();
		
	}
	
	@GetMapping("/workers/get")
	public List<Worker> findByFirstName(@RequestParam("firstName")String firstName)
	{
		return workerService.findByFirstName(firstName);
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
