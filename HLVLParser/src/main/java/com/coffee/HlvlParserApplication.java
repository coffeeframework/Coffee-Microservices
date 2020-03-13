package com.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class HlvlParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(HlvlParserApplication.class, args);
	}

}
