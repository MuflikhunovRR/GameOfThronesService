package ru.gotoqa.GameOfThronesService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gotoqa.GameOfThronesService.repository.CharacterRepository;
import ru.gotoqa.GameOfThronesService.models.Character;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping("/version2/characters")
    List<Character> findAll(){
        return characterRepository.findAll();
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/actors")
//    Actor newActor(@RequestBody Actor actor){
//        return actorRepository.save(actor);
//    }
//
//    @GetMapping("/actors/{id}")
//    Actor findOne(@PathVariable Long id) {
//        return actorRepository.findById(id)
//                .orElseThrow(() -> new ActorNotFoundException(id));
//    }
//
//    // Save or update
//    @PutMapping("/actors/{id}")
//    Actor saveOrUpdate(@RequestBody Actor newActor, @PathVariable Long id) {
//
//        return actorRepository.findById(id)
//                .map(x -> {
//                    x.setFirstName(newActor.getFirstName());
//                    x.setLastName(newActor.getLastName());
//                    x.setBirthDay(newActor.getBirthDay());
//                    return actorRepository.save(x);
//                })
//                .orElseGet(() -> {
//                    newActor.setId(id);
//                    return actorRepository.save(newActor);
//                });
//    }
//
//    // update setLastName only
//    @PatchMapping("/actors/{id}")
//    Actor patch(@RequestBody Map<String, String> update, @PathVariable Long id) {
//
//        return actorRepository.findById(id)
//                .map(x -> {
//
//                    String author = update.get("author");
//                    if (!StringUtils.isEmpty(author)) {
//                        x.setLastName(author);
//
//                        // better create a custom method to update a value = :newValue where id = :id
//                        return actorRepository.save(x);
//                    } else {
//                        throw new ActorUnSupportedFieldPatchException(update.keySet());
//                    }
//
//                })
//                .orElseGet(() -> {
//                    throw new ActorNotFoundException(id);
//                });
//
//    }
//
//    @DeleteMapping("/actors/{id}")
//    void deleteBook(@PathVariable Long id) {
//        actorRepository.deleteById(id);
//    }
}
