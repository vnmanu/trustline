package com.blockchain.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blockchain.demo.controller.AgentManager;
import com.blockchain.demo.controller.DemoController;

@SpringBootApplication
public class BlockchainApplication {
	@Autowired
	private static AgentManager agentManager;
	
	private static final Logger logger = LogManager.getLogger(BlockchainApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BlockchainApplication.class, args);
		logger.info("Welcome to the Trustline");
		logger.info("Trustline balance is: " + DemoController.balance);
		
		//Adding users
		//agentManager.addUser("Alice","localhost","8080");
		//agentManager.addUser("Bob","localhost","8080");
	}
}
