package com.API.Login;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication//no
@EnableCaching  //reduces no. of fire of queries and decreases response time of system
public class LoginApiExerciseApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(LoginApiExerciseApplication.class, args);
	}
	@Override      //to use this run() method implement ApplicationRunner interface
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			RestTemplate restTemplate=new RestTemplate();
			ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/health", String.class);
			
			HttpStatus statusCode = response.getStatusCode();
			
			if(statusCode==HttpStatus.OK) {
				System.out.println("Service is UP!! and everything is okk");
			}
			
		} catch (Exception e) {
			System.out.println("Service is down!! please run [MyonetoM] project for practicing ApplicationRunner ");
		}
	}

}
