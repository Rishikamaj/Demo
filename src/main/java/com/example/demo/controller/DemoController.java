package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.model.LoginResponse;
import com.example.demo.repository.LoginRepo;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/demo")
public class DemoController {
	@Autowired
	public LoginRepo loginRepo;

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/hello", method = RequestMethod.POST ,produces = {
	"application/json" }, consumes = { "application/json" })
	public Login test(@RequestBody Login login) {
		System.out.println("Request username " + login.getUsername());
		Login resp = new Login();
		resp.setUsername(login.getUsername());
		
		return resp;
	}
	
	@RequestMapping(value = "/getCred", method = RequestMethod.POST, produces = {
	"application/json" }, consumes = { "application/json" })
	    public LoginResponse index(@RequestBody Login login) {
		System.out.println("Hello");
			LoginResponse response = new LoginResponse();
//	    	String username = "prati";
//	    	String password = "12345";
//	    	String status = null;
	    	Login userDetail = loginRepo.findByPassword(login.getPassword());
	    	System.out.println("Hello "+userDetail);
	    	if(userDetail != null) {
	    		if (userDetail.getUsername().equals(login.getUsername())) {
	    			response.setUserName(login.getUsername());
	    			response.setStatusCode(200);
	    		}
	    		else {
		    		response.setUserName("Not Valid");
	    			response.setStatusCode(400);
		    	}
	    	} else {
	    		response.setUserName("Not Matches");
    			response.setStatusCode(400);
	    	}
			return response;
	    	
	    }
}
