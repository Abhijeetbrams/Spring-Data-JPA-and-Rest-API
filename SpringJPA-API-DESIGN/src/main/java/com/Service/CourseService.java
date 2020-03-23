package com.Service;

import java.util.List;

import com.Entity.Course;

public interface CourseService {

    public List<Course> findAll();
	
	public Course findById(int theId);
//	
	public void save(Course theCourse);
//	
	public void deleteById(int theId);
	
	//public void saveOrUpdate(Department theDepartment);
}
