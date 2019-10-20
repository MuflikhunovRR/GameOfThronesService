package ru.gotoqa.GameOfThronesService.models;

import io.swagger.annotations.ApiModelProperty;
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
public class Actor {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "The database generated actor's ID")
    private Long id;
    @ApiModelProperty(notes = "Actor first name", required = true)
    private String firstName;
    @ApiModelProperty(notes = "Actor second name", required = true)
    private String lastName;
    @ApiModelProperty(notes = "Actor birthDay", required = true)
    private String birthDay;

    public Actor(String firstName, String lastName, String birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
    }


}
