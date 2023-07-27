package com.bridgelabz.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
/**Section 3
 * UC2..............................
 * Use Lombok Library for
 * Logging
 * UC3............................
 * Determine the Logging Levels, Logging
 * to Console or File, Logging Patterns, etc
 * based on this application running in
 * Dev, Staging or Production - Note we create application.properties for
 */
public class AddressBookAppApplication {

	public static void main(String[] args) {
		log.info("AddressBookMain started.");
		SpringApplication.run(AddressBookAppApplication.class, args);
	}

}
