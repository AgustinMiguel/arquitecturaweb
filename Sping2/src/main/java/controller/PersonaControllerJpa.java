package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import model.Persona;
import repository.PersonaRepositorio;

@RestController
@RequestMapping("personas1")
public class PersonaControllerJpa {

    @Qualifier("PersonaRepository")
    @Autowired
    private final PersonaRepositorio repository;

    public PersonaControllerJpa(@Qualifier("PersonaRepository") PersonaRepositorio repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Iterable<Persona> getPersonas() {
        return repository.findAll();
    }

    @GetMapping("/BySurname/{surname}")
    public Iterable<Persona> getPersonasBySurname(@PathVariable String surname) {
        return repository.findAllBySurname(surname);
    }

    @GetMapping("/ByName/{name}")
    public Iterable<Persona> getPersonasByName(@PathVariable String name) {
        return repository.findAllByName(name);
    }

    @PostMapping("/")
    public Persona newPersona(@RequestBody Persona p) {
        return repository.save(p);
    }

    @GetMapping("/{id}")
    Optional<Persona> one(@PathVariable Long id) {

        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Persona replacePersona(@RequestBody Persona newPersona, @PathVariable Long id) {

        return repository.findById(id)
                .map(Persona -> {
                    Persona.setName(newPersona.getName());
                    Persona.setSurname(newPersona.getSurname());
                    return repository.save(Persona);
                })
                .orElseGet(() -> {
                    newPersona.setDni(id);
                    return repository.save(newPersona);
                });
    }

    @DeleteMapping("/{id}")
    void deletePersona(@PathVariable Long id) {
        repository.deleteById(id);
    }
}