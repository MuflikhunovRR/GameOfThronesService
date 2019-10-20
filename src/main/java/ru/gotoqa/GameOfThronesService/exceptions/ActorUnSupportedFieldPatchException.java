package ru.gotoqa.GameOfThronesService.exceptions;

import java.util.Set;

public class ActorUnSupportedFieldPatchException extends RuntimeException {

    public ActorUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}