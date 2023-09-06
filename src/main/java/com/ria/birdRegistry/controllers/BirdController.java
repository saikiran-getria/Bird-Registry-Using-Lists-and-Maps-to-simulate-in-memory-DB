package com.ria.birdRegistry.controllers;

import com.ria.birdRegistry.model.Bird;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BirdController {
    private Map<String, Bird> birdDB = new HashMap<>();
    @PostMapping("/birds")
    public ResponseEntity<Bird> addBird(@RequestBody Bird bird) {

        bird.setId(bird.getId());
        bird.setName(bird.getName());
        bird.setFamily(bird.getFamily());
        bird.setContinents(bird.getContinents());
        bird.setAdded(bird.getAdded());
        bird.setVisible(bird.isVisible());
        birdDB.put(bird.getId(),bird );
        return new ResponseEntity<>(bird, HttpStatus.CREATED);
    }

    @GetMapping("/birds")
    public ResponseEntity<List<Bird>> listBirds() {
        List<Bird> visibleBirds = birdDB.values().stream()
                .filter(Bird::isVisible)
                .collect(Collectors.toList());
        return new ResponseEntity<>(visibleBirds, HttpStatus.OK);
    }


    @GetMapping("/birds/")
    public ResponseEntity<List<Bird>> listSpecificBirds(@RequestParam boolean visible,@RequestParam String family) {
        List<Bird> displayBirds = birdDB.values().stream()
                .filter(bird -> bird.isVisible().equals(visible) && bird.getFamily().equals(family))
                .collect(Collectors.toList());
        return new ResponseEntity<>(displayBirds, HttpStatus.OK);
    }

    @GetMapping("/birds/{id}")
    public ResponseEntity<Bird> getBirdById(@PathVariable("id") String id) {
        Bird bird = birdDB.get(id);
        if (bird == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bird, HttpStatus.OK);
    }

    @DeleteMapping("/birds/{id}")
    public ResponseEntity<Void> deleteBirdById(@PathVariable("id") String id) {
        Bird removedBird = birdDB.remove(id);
        if (removedBird == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
