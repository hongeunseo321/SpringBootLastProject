package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLastProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLastProjectApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner runner(GoogleGenAiChatModel model) {
		return arge->{
			String response=model.call("마포구 여행 일정");
			System.out.println(response);
		};
	}
	*/
}
