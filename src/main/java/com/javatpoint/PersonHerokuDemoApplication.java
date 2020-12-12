package com.javatpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PersonHerokuDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonHerokuDemoApplication.class, args);
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {
		personRepository.save(new Person(101, "Elena", "Female", "Fine"));
		personRepository.save(new Person(102, "Mihai", "Male", "Super"));
		personRepository.save(new Person(103, "Maria", "Female", "Bad"));
		personRepository.save(new Person(104, "Victor", "Male", "So so"));

		//personRepository.deleteById(103);
	}
}
