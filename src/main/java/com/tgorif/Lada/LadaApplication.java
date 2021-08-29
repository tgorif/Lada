package com.tgorif.Lada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class LadaApplication implements CommandLineRunner {

	@Autowired
	ConsumableManager consumableManager;

	public static void main(String[] args) {
		SpringApplication.run(LadaApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		for(Map.Entry<String,Integer> e : consumableManager.getQuantities().entrySet()){
			System.out.println(e.getKey()  + " " + e.getValue());
		}
	}

}
