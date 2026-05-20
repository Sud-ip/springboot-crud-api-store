package com.example.ecomerce_spring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomerceSpringApplication {




	public static void main(String[] args)
	{
		//	configuration of dotenv - java
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach((entry) -> System.setProperty(
				entry.getKey(),entry.getValue()
		));


		SpringApplication.run(EcomerceSpringApplication.class, args);
	}

}
