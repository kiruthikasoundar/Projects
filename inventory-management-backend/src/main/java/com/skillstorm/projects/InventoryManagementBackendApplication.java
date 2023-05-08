package com.skillstorm.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class of the inventory management back-end application.
 * This class uses Spring Boot to launch the application and starts the server.
 * 
 * To start the application, run the main method of this class.
 */
@SpringBootApplication
public class InventoryManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementBackendApplication.class, args);
	}

}
