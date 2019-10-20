package ru.gotoqa.GameOfThronesService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gotoqa.GameOfThronesService.models.Character;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
