package ru.gotoqa.GameOfThronesService.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.gotoqa.GameOfThronesService.exceptions.ActorNotFoundException;
import ru.gotoqa.GameOfThronesService.exceptions.ActorUnSupportedFieldPatchException;
import ru.gotoqa.GameOfThronesService.models.Actor;
import ru.gotoqa.GameOfThronesService.repository.ActorRepository;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/gameofthrones")
@Api(value="GameOfThronesService", description="Actor WEB Service")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/version1/actors")
    @ApiOperation(value = "Returns list of all Actors")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    List<Actor> findAll(){
        return actorRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/version1/actors")
    Actor newActor(@RequestBody Actor actor){
        return actorRepository.save(actor);
    }

    @GetMapping("/version1/actors/{id}")
    @ApiOperation(value = "Returns Actor data")
    Actor findOne(@ApiParam("Id of the Actors to be obtained. Cannot be empty.") @PathVariable Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));
    }

    @PutMapping("/version1/actors/{id}")
    Actor saveOrUpdate(@RequestBody Actor newActor, @PathVariable Long id) {

        return actorRepository.findById(id)
                .map(x -> {
                    x.setFirstName(newActor.getFirstName());
                    x.setLastName(newActor.getLastName());
                    x.setBirthDay(newActor.getBirthDay());
                    return actorRepository.save(x);
                })
                .orElseGet(() -> {
                    newActor.setId(id);
                    return actorRepository.save(newActor);
                });
    }

    @PatchMapping("/version1/actors/{id}")
    Actor patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return actorRepository.findById(id)
                .map(x -> {

                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)) {
                        x.setLastName(author);

                        return actorRepository.save(x);
                    } else {
                        throw new ActorUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new ActorNotFoundException(id);
                });

    }

    @DeleteMapping("/version1/actors/{id}")
    void deleteActor(@PathVariable Long id) {
        actorRepository.deleteById(id);
    }
}
