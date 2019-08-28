package com.test.ssl.rest;

import javax.xml.ws.ResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ssl.ws.TestWService;

@RestController("/account")
public class TestResource {
	
	Logger LOG = LoggerFactory.getLogger(TestResource.class);
	
	@Autowired
	TestWService accountWService;
	
	/**
	 * Create account
	 * @param account
	 * @return
	 */
	@RequestMapping
	public ResponseWrapper createAccount(){
		ResponseWrapper reponseWrapper = accountWService.createAccount();
		return reponseWrapper;
	}
	

}
