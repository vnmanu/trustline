package com.blockchain.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.blockchain.demo.controller.AgentManager.UserDetails;

@RestController
public class DemoController {
	
	@Autowired
	private AgentManager agentManager;
	
	public static int balance;
	
	private static final Logger logger = LogManager.getLogger(DemoController.class);
	
	@RequestMapping("/credit")
	public void credit(@RequestParam(value="creditUser") String creditUser, @RequestParam(value="debitUser") String debitUser, @RequestParam(value="amount") String amount){
		balance-=Integer.parseInt(amount);
		logger.info("Paying "+amount +" to "+ debitUser +"... " + amount + "!");
		logger.info("Trustline balance is: " + DemoController.balance);
		UserDetails user = agentManager.getUser("debitUser");
		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.getForObject("http://localhost:8090/debit?debitUser=bob&amount="+amount, String.class);
	        
	}
	
	@RequestMapping("/debit")
	public void debit(@RequestParam(value="debitUser") String debitUser, @RequestParam(value="amount") String amount){
		balance+=Integer.parseInt(amount);
		logger.info("You were paid " + amount + "!");
		logger.info("Trustline balance is: " + DemoController.balance);
	}

}
