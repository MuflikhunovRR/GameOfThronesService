package ru.gotoqa.GameOfThronesService.exceptions;

public class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException(Long id) {
        super("Actor id not found : " + id);
    }
}
