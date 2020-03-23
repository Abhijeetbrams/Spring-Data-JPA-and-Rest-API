package com.Service;

import java.util.List;

import com.Entity.Bonus;
import com.Entity.Instructor;

public interface InstructorService {

    public List<Instructor> findAll();
	
	public Instructor findById(int theId);
//	
	public void save(Instructor theInstructor);
//	
	public void deleteById(int theId);
	
	//public void saveOrUpdate(Department theDepartment);
}
