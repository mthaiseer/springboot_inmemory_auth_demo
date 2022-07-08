package io.code.inmemoryauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class InmemoryauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(InmemoryauthApplication.class, args);

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("jim123"));
		System.out.println(bCryptPasswordEncoder.encode("peter123"));
		System.out.println(bCryptPasswordEncoder.encode("catalina123"));

	}

}
