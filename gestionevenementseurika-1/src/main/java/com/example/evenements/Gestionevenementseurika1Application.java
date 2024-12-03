package com.example.evenements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.evenements.entities.Evenement;
import com.example.evenements.entities.Theme;


@EnableDiscoveryClient
@SpringBootApplication
public class Gestionevenementseurika1Application implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(Gestionevenementseurika1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		repositoryRestConfiguration.exposeIdsFor(Evenement.class, Theme.class);
	}

}
