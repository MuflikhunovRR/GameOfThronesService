package ru.gotoqa.GameOfThronesService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gotoqa.GameOfThronesService.models.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
