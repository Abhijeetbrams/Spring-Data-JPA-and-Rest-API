package com.Service;

import java.util.List;

import com.Entity.Bonus;

public interface BonusService {

    public List<Bonus> findAll();
	
	public Bonus findById(int theId);
//	
	public void save(Bonus theBonus);
//	
	public void deleteById(int theId);
	
	//public void saveOrUpdate(Department theDepartment);
}
