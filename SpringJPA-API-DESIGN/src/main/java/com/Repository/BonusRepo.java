package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Bonus;

public interface BonusRepo extends JpaRepository<Bonus, Integer> {

}
