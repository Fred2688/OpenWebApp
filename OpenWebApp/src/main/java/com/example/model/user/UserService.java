package com.example.model.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

@Service
public class UserService{

	@Autowired
	UserRepository userRepository;

	public void addUser(User user){
		userRepository.save(user);
	}

	public ArrayList<User> getAllUser(){
		ArrayList<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	public boolean login(String name, String password){
		User user = userRepository.findOne(name);
		if (user==null) return false;
		return user.getPassword().equals(password);
	}

/*	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
        // Ideally it should be fetched from database and populated instance of
        // #org.springframework.security.core.userdetails.User should be returned from this method
        UserDetails user = (UserDetails) new User(username, "demo");
        return user;
	
	}*/
}
