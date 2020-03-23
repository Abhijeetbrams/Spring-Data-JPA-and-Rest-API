package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Worker;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Integer> {

}
