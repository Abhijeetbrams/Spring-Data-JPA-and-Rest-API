package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
