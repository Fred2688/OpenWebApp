package com.example.login;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.user.User;
import com.example.model.user.UserService;

@RestController
@RequestMapping(value = "/user")
public class LoginController {

	JsonParser parser = new BasicJsonParser();
	@Autowired
	private UserService userService;


	/*Permet d'ajouter un utilisateur - (pas utilisée dans ce projet)*/
	@RequestMapping(method = RequestMethod.POST)
	public void newUser(@RequestParam("name") String name, @RequestParam("password")String password){
		User user = new User(name,password);
		userService.addUser(user);

	}
	/*Permet de vérifier si l'utilisateur à rentrer le bon login correspondant au mdp*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean login(@RequestBody String body) {
		Map<String, Object> map = parser.parseMap(body);
		return userService.login(map.get("name").toString(), map.get("password").toString());
	}
}


