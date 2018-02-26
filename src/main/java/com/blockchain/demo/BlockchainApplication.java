package com.blockchain.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blockchain.demo.controller.AgentManager;
import com.blockchain.demo.controller.DemoController;

@SpringBootApplication
public class BlockchainApplication {
	@Autowired
	private static AgentManager agentManager;
	
	public static void main(String[] args) {
		SpringApplication.run(BlockchainApplication.class, args);
		System.out.println("Welcome to the Trustline");
		System.out.println("Trustline balance is: " + DemoController.balance);
		//Adding users
		//agentManager.addUser("Alice","localhost","8080");
		//agentManager.addUser("Bob","localhost","8080");
	}
}
