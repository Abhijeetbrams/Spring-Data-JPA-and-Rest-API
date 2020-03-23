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
	
	//public void saveOrUpdate(Department theDepartment);
}
