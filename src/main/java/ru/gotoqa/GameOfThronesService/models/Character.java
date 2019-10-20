package ru.gotoqa.GameOfThronesService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue
    private Long id;
    private Long actor_id;
    private String firstName;
    private String lastName;

    public Character(Long actor_id, String firstName, String lastName) {
        this.actor_id = actor_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
