package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Worker;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Integer> {

	@Query(value="select max(salary),department from worker group by department",nativeQuery=true)
	public List<Object> findMaxSalByDepartment();
	
	 @Query(value="select * from worker  where first_name like %?1",nativeQuery=true)
	 public List<Worker> findByFirstName(String firstName);
	 
}
