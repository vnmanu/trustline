package com.blockchain.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class AgentManager {
	
	public static Map< String, UserDetails> userList = new HashMap<>();
	
	class UserDetails {
	public String server;
	
	public String port;
	
	public String user;
	
	public UserDetails(String user, String server, String port) {
		
	}
	
	public String getServer() {
		return server;
	}
	
	public void setServer(String server) {
		this.server = server;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	}
	
	public UserDetails addUser(String user, String server, String port){
		UserDetails newUser = new UserDetails(user, server,port);
		userList.put(user, newUser);
		return newUser;
	}
	
	public UserDetails getUser(String user){
		return userList.get(user);
	}

}
