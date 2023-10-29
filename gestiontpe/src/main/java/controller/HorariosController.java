package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.HorariosService;
import models.Horarios;


@RestController
@RequestMapping("/api/horarios/")
public class HorariosController {

    @Autowired
    private HorariosService horariosService;
    
    @GetMapping
    private ResponseEntity<List<Horarios>> listAll(){
        return ResponseEntity.ok(horariosService.getAllHorarios());
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Horarios>> listarPorId (@PathVariable ("id") Integer id){
        return ResponseEntity.ok(horariosService.findById(id));

    }

    
}
