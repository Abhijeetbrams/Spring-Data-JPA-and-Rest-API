package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Bonus;
import com.Entity.Course;
import com.Repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	//@Qualifier("leaveTrackingRepository")
	private CourseRepo courseRepo;
	
	
    @Override
	public List<Course> findAll() {
    	System.out.println( courseRepo.findAll()+"kjdsjkjhdjkj");
		return  courseRepo.findAll();
	}
    
@Override
	public Course findById(int theId) {
		Optional<Course> result=courseRepo.findById(theId);
		
		Course theCourse=null;
		if(result.isPresent())
		{
			theCourse=result.get();
		}
		else
		{
			throw new RuntimeException("Didn't find any leave by that Id-"+theId);
		}
		
		return theCourse;
		
	}

	@Override
	public void save(Course theCourse) {
		courseRepo.save(theCourse);
	}

	@Override
	
	public void deleteById(int theId) {
		courseRepo.deleteById(theId);
	}
	
   
}
