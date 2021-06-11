package com.sogne;

import com.sogne.models.Commune;
import com.sogne.models.Parish;
import com.sogne.repository.CommuneRepository;
import com.sogne.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sogneprojekt1Application {

    public static void main(String[] args) {
        SpringApplication.run(Sogneprojekt1Application.class, args);

    }

}
