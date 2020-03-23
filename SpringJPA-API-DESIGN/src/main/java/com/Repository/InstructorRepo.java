package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer> {

}
