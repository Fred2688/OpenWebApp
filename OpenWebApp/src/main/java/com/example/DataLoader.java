package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.alcohol.Alcohol;
import com.example.model.alcohol.AlcoholRepository;
import com.example.model.alcohol.Drink;
import com.example.model.alcohol.DrinkRepository;
import com.example.model.user.User;
import com.example.model.user.UserRepository;

/*Permet d'ajouter des données dans la db avant le lancement du programme*/

@Component
public class DataLoader {

	private UserRepository userRepository;
	private AlcoholRepository alcoolRepository;
	private DrinkRepository drinkRepository;

	@Autowired
	public DataLoader(UserRepository userRepository, AlcoholRepository alcoolRepository, DrinkRepository drinkRepository) {
		this.userRepository = userRepository;
		this.alcoolRepository = alcoolRepository;
		this.drinkRepository = drinkRepository;
		LoadUsers();
		LoadAlcohols();
	}

	private void LoadUsers() {
		userRepository.save(new User("demo","demo"));
	}


	private void LoadAlcohols() {
		Alcohol a1 = new Alcohol("Whisky");
		alcoolRepository.save(a1);
		drinkRepository.save(new Drink("William Peel", a1));
		Alcohol a2 = new Alcohol("Gin");
		alcoolRepository.save(a2);
		Alcohol a3 = new Alcohol("Vodka");
		alcoolRepository.save(a3);
		Alcohol a4 = new Alcohol("Beer");
		alcoolRepository.save(a4);
		drinkRepository.save(new Drink("Guiness", a4));
		drinkRepository.save(new Drink("Corona", a4));
		Alcohol a5 = new Alcohol("Wine");
		alcoolRepository.save(a5);
		Alcohol a6 = new Alcohol("Tequila");
		alcoolRepository.save(a6);
		drinkRepository.save(new Drink("Tequila Sunrise", a6));

	}
}