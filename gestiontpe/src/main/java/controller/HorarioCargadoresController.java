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

import models.HorarioAutobuses;
import models.HorarioCargadores;
import service.HorarioCargadoresService;

@RestController
@RequestMapping ("/api/horarioCargadores/")
public class HorarioCargadoresController {
    
    @Autowired
    private HorarioCargadoresService horarioCargadoresService;

    @GetMapping
    private ResponseEntity<List<HorarioCargadores>> listAll(){
        return ResponseEntity.ok(horarioCargadoresService.getAllHorarioCargadores());
    }

    @PostMapping
    private ResponseEntity<HorarioCargadores> guardar(@RequestBody HorarioCargadores horarioCargador){
        HorarioCargadores tmp = horarioCargadoresService.create(horarioCargador);

        try {
            return ResponseEntity.created(new URI("/api/horarioCargadores"+tmp.getAutobus_id())).body(tmp);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<HorarioCargadores>> listarPorId(@PathVariable ("id") Integer id){
        return ResponseEntity.ok(horarioCargadoresService.findById(id));

    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarHorarioAutobus(@RequestBody HorarioCargadores horarioCargador){
        horarioCargadoresService.delete(horarioCargador);
        return ResponseEntity.ok().build();
    }


}
