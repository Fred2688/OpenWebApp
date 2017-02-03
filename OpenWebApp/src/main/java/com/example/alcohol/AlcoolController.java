package com.example.alcohol;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.alcohol.Alcohol;
import com.example.model.alcohol.AlcoholService;
import com.example.model.alcohol.Drink;

@RestController
@RequestMapping(value = "/alcohol")
public class AlcoolController {
	
	JsonParser parser = new BasicJsonParser();
	
	@Autowired
	private AlcoholService alcoholService;
	
	/*Retourne la liste des alcools contenus dans la db*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Alcohol>getAlcoholList(){
		return alcoholService.getAlcoholList();
	}
	/*Retourne un alcool selon son id*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Alcohol getAlcohol(@PathVariable("id")Long id){
		return alcoholService.getAlcohol(id);
	}
	/*Ajoute un alcool dans la db*/
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Alcohol addAlcohol(@RequestBody String body) {
		Map<String, Object> map = parser.parseMap(body);
		return alcoholService.addAlcohol(new Alcohol(map.get("name").toString()));
	}

	/*Ajoute une boisson dans la db*/
	@RequestMapping(value = "/{id}/drink", method = RequestMethod.POST)
	public Drink addDrink(@PathVariable("id")Long id, @RequestBody String body) {
		Map<String, Object> map = parser.parseMap(body);
		Alcohol alcohol = alcoholService.getAlcohol(id);
		return alcoholService.addDrink(new Drink(map.get("name").toString(), alcohol));
	}

}
