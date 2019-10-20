package ru.gotoqa.GameOfThronesService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.gotoqa.GameOfThronesService.models.Actor;
import ru.gotoqa.GameOfThronesService.models.Character;
import ru.gotoqa.GameOfThronesService.repository.ActorRepository;
import ru.gotoqa.GameOfThronesService.repository.CharacterRepository;

@SpringBootApplication
public class GameOfThronesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameOfThronesServiceApplication.class, args);
	}

	// init bean to insert 3 books into h2 database.
	@Bean
	CommandLineRunner initDatabase(ActorRepository repository, CharacterRepository characterRepository) {
		return args -> {
			repository.save(new Actor("Emilia", "Clarke", "23 October 1986"));
			repository.save(new Actor("Peter", "Dinklage", "11 June 1969"));
			repository.save(new Actor("Lena", "Headey", "3 October 1973"));
			characterRepository.save(new Character(1L, "Daenerys", "Targaryen"));
		};
	}

}
