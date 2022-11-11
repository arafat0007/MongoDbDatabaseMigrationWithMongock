package com.example.MongockMongoDB;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class MongockMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongockMongoDbApplication.class, args);
	}

}
