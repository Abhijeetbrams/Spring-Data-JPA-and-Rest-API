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
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Bonus;
import com.Entity.Respose;
import com.Entity.Worker;
import com.Service.BonusService;
import com.amazonaws.xray.spring.aop.XRayEnabled;
//import com.POJO.Department;
@RestController
@XRayEnabled
@RequestMapping("/api")
public class BonusController {

	@Autowired
	private BonusService bonusService;
	
	@GetMapping("/bonus")
	public List<Bonus> findAll()
	{
	   
		return  bonusService.findAll();
		
	}
	
	@GetMapping("/bonus/{id}")
	public Bonus findById(@PathVariable("id") int theId)
	{
		
		
		return bonusService.findById(theId);
	
	}
	
	
	
	@PostMapping("/bonus")
	public ResponseEntity<Respose> save(@RequestBody Bonus theBonus)
	{
		theBonus.setId(0);;
		bonusService.save(theBonus);
		Respose response = new Respose();
		response.setCode(HttpStatus.CREATED.toString());
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		response.setDate(dtf.format(now));
		response.setMessage("Succesfully Inserted");
		
		return new ResponseEntity(response,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/bonus/{id}")
	public ResponseEntity<Respose> delete(@PathVariable("id") int theId)
	{
		bonusService.deleteById(theId);
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
