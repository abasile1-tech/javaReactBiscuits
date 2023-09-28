package com.example.javaBiscuitsAPI.controllers;

import com.example.javaBiscuitsAPI.models.Tea;
import com.example.javaBiscuitsAPI.repositories.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeaController {
    @Autowired
    TeaRepository teaRepository;

    @GetMapping(value = "/api/teas")
    public List<Tea> getAllTeas() {
        return teaRepository.findAll();
    }

    @GetMapping(value = "/api/teas/{id}")
    public Optional<Tea> getTea(@PathVariable Long id) {
        return teaRepository.findById(id);
    }

    @PostMapping(value = "/api/teas")
    public Tea createTea(@RequestBody Tea tea) {
        return teaRepository.save(tea);
    }

    @DeleteMapping(value = "/api/teas/{id}")
    public void deleteTea(@PathVariable Long id) {
        teaRepository.deleteById(id);
    }

    @PutMapping(value = "/api/teas/{id}")
    public Tea replaceTea(@PathVariable Long id, @RequestBody Tea newTea) {
        return teaRepository.findById(id).map((tea) -> {
            tea.setName(newTea.getName());
            tea.setBrand(newTea.getBrand());
            return teaRepository.save(tea);
        }).orElseGet(() -> {
            newTea.setId(id);
            return teaRepository.save(newTea);
        });
    }

}
