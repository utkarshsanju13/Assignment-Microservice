package com.apigateway.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("/customermanagementServiceFallback")
	public String userServiceFallback() {
		return "Customer service is down at this time !!";
	}
	
	@GetMapping("/accountmanagementServiceFallback")
	public String contactServiceFallback() {
		return "Account service is down at this time !!";
	}


}
