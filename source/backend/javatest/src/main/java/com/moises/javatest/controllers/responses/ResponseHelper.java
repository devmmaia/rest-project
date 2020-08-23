package com.moises.javatest.controllers.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {
	public static ResponseEntity<DefaultResponse> createResponse(Object result, HttpStatus status, String... messages) {
		DefaultResponse body = new DefaultResponse();
		body.setResult(result);
		body.setMessages(messages);
		body.setStatus(status.toString());
		body.setStatusCode(status.value());
		
		return ResponseEntity.status(status).body(body);
	}
	
	public static ResponseEntity<DefaultResponse> notFound(){
		
		return createResponse(null, HttpStatus.NOT_FOUND, "Nao encontrado");
	}
	

}
