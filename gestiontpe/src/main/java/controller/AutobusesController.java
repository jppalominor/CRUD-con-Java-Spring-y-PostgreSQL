package controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Autobuses;
import service.AutobusesService;

@RestController
@RequestMapping ("/api/autobuses/")
public class AutobusesController {
    
    @Autowired
    private AutobusesService autobusService;
    
    @PostMapping
    private ResponseEntity<Autobuses> guardar (@RequestBody Autobuses autobus){
        Autobuses temporal = autobusService.create(autobus);

        try {
            return ResponseEntity.created(new URI("/api/autobuses"+temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


    @GetMapping
    private ResponseEntity<List<Autobuses>> listarAll (){
        return ResponseEntity.ok(autobusService.getAllAutobuses());
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarAutobus (@RequestBody Autobuses autobus){
        autobusService.delete(autobus);
        return ResponseEntity.ok().build();
    }


    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Autobuses>> listarPorId (@PathVariable ("id") Integer id){
        return ResponseEntity.ok(autobusService.findById(id));

    }


}
