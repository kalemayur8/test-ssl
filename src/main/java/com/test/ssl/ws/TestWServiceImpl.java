package com.test.ssl.ws;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.ResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestWServiceImpl implements TestWService {
	
	Logger LOG = LoggerFactory.getLogger(TestWServiceImpl.class);
	
	
	@Override
	public ResponseWrapper createAccount() {
		HttpHeaders headers = getHeaders();
		Map<String, String> body = new HashMap();
		/* body.put("grant_type", "client_credentials"); */
		HttpEntity<Map> httpEntity = new HttpEntity<Map>(body, headers);
		postAPIDat(httpEntity, headers);
		return null;
	}
	
	
	public HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", "application/x-www-form-urlencoded");
		headers.add("Authorization", "Basic ZXRhZ3N0bXNfY2xpZW50OmNpcEc1Y09qd2RnUE01MkhpVE9sZXpJRTBPUmYwN0RwQ0xiMFdlQXFZY0g0TWhhM0phZ3NzODloZFU3QmZVQTU=");
		return headers;
	}
	
	private void postAPIDat(HttpEntity<Map> body, HttpHeaders headers) {
		RestTemplate restTemplate = new RestTemplate();
		LOG.info("Request : {} ", body);
		LOG.info("Header : {} ", headers);
		ResponseEntity<String> responseWrapper = restTemplate.postForEntity(
				"https://ssodev.emirates.com/as/token.oauth2?grant_type=client_credentials",
				new HttpEntity<>(headers), String.class);
		LOG.info("Response : {} ", responseWrapper);
	}
	
}
