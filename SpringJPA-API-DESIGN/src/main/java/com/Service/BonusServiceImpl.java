package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Bonus;
import com.Repository.BonusRepo;

@Service
public class BonusServiceImpl implements BonusService{

	@Autowired
	//@Qualifier("leaveTrackingRepository")
	private BonusRepo bonusRepo;
	
	
    @Override
	public List<Bonus> findAll() {
    	System.out.println( bonusRepo.findAll()+"kjdsjkjhdjkj");
		return  bonusRepo.findAll();
	}
    
@Override
	public Bonus findById(int theId) {
		Optional<Bonus> result=bonusRepo.findById(theId);
		
		Bonus theWorker=null;
		if(result.isPresent())
		{
			theWorker=result.get();
		}
		else
		{
			throw new RuntimeException("Didn't find any leave by that Id-"+theId);
		}
		
		return theWorker;
		
	}

	@Override
	public void save(Bonus theWorker) {
		bonusRepo.save(theWorker);
	}

	@Override
	
	public void deleteById(int theId) {
		bonusRepo.deleteById(theId);
	}
	
   
}
