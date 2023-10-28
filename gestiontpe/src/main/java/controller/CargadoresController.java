package controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Cargadores;
import service.CargadoresService;

@RestController
@RequestMapping("/api/cargadores/")
public class CargadoresController {

    @Autowired
    private CargadoresService cargadoresService;

    @GetMapping
    private ResponseEntity<List<Cargadores>> listAll(){
        return ResponseEntity.ok(cargadoresService.getAllCargadores());
    }

    @PostMapping
    private ResponseEntity<Cargadores> guardar(@RequestBody Cargadores cargador){
        Cargadores tmp = cargadoresService.create(cargador);

        try {
            return ResponseEntity.created(new URI("/api/autobuses"+tmp.getId())).body(tmp);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarCargador(@RequestBody Cargadores cargador){
        cargadoresService.delete(cargador);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Cargadores>> listarPorId (@PathVariable ("id") Integer id){
        return ResponseEntity.ok(cargadoresService.findById(id));

    }

    
}
