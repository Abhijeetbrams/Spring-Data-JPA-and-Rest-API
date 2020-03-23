package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Instructor;
import com.Repository.InstructorRepo;

@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	//@Qualifier("leaveTrackingRepository")
	private InstructorRepo instructorRepo;
	
	
    @Override
	public List<Instructor> findAll() {
    	System.out.println( instructorRepo.findAll()+"kjdsjkjhdjkj");
		return  instructorRepo.findAll();
	}
    
@Override
	public Instructor findById(int theId) {
		Optional<Instructor> result=instructorRepo.findById(theId);
		
		Instructor theInstructor=null;
		if(result.isPresent())
		{
			theInstructor=result.get();
		}
		else
		{
			throw new RuntimeException("Didn't find any leave by that Id-"+theId);
		}
		
		return theInstructor;
		
	}

	@Override
	public void save(Instructor theInstructor) {
		instructorRepo.save(theInstructor);
	}

	@Override
	
	public void deleteById(int theId) {
		instructorRepo.deleteById(theId);
	}
	
   
}
