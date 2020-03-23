package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Entity.Worker;
//import com.POJO.LeaveTracking;
//import com.POJO.LeaveTracking;
//import com.POJO.LeaveTracking;
import com.Repository.WorkerRepo;

@Service
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	//@Qualifier("leaveTrackingRepository")
	private WorkerRepo workerRepo;
	
	
    @Override
	public List<Worker> findAll() {
    	System.out.println( workerRepo.findAll()+"kjdsjkjhdjkj");
		return  workerRepo.findAll();
	}
    
@Override
	public Worker findById(int theId) {
		Optional<Worker> result=workerRepo.findById(theId);
		
		Worker theWorker=null;
		if(result.isPresent())
		{
			theWorker=result.get();
		}
		else
		{
			throw new RuntimeException("Didn't find any leave by that Id-"+theId);
		}
		System.out.println(workerRepo.findById(theId));
		return theWorker;
		
	}

	@Override
	public void save(Worker theWorker) {
		workerRepo.save(theWorker);
	}

	@Override
	
	public void deleteById(int theId) {
		workerRepo.deleteById(theId);
	}
	
   
}
