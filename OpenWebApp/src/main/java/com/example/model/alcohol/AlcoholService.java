package com.example.model.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlcoholService {
	
	@Autowired
	AlcoholRepository alcoholRepository;
	@Autowired
	DrinkRepository drinkRepository;
	
	public Alcohol addAlcohol(Alcohol alcohol){
		return alcoholRepository.save(alcohol);
	}
	
	public Iterable<Alcohol> getAlcoholList(){
		return alcoholRepository.findAll();
	}
	
	public Alcohol getAlcohol(Long id){
		return alcoholRepository.findOne(id);
	}
	
	public Drink addDrink(Drink drink){
		return drinkRepository.save(drink);
	}
	
	

}
