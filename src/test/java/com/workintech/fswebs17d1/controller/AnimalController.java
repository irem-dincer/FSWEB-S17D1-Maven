package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals=new HashMap<>();

    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id){
        return animals.get(id);
    }
@PostMapping
    public Animal save(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
        return  animal;
}

@PutMapping("{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id, animal);
        return animal;
}

@DeleteMapping("{id}")
    public Animal delete(@PathVariable int id){
        Animal animal=animals.get(id);
        animals.remove(id);
        return  animal;
}



}
