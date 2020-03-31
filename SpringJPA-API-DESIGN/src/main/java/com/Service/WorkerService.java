package com.Service;

import java.util.List;

import com.Entity.Worker;

public interface WorkerService {

    public List<Worker> findAll();
	
	public Worker findById(int theId);
//	
	public void save(Worker theWorker);
//	
	public void deleteById(int theId);
	
	public List<Object> findMaxSalByDepartment();
	
	 public List<Worker> findByFirstName(String firstName);
	
	//public void saveOrUpdate(Department theDepartment);
}
