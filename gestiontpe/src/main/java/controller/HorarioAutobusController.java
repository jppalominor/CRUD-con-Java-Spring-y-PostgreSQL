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
import models.HorarioAutobuses;
import models.Horarios;
import service.HorarioAutobusesService;

@RestController
@RequestMapping("/api/horarioAutobus/")
public class HorarioAutobusController {
    
    @Autowired
    private HorarioAutobusesService horarioAutobusesService;

    @GetMapping
    private ResponseEntity<List<HorarioAutobuses>> listAll(){
        return ResponseEntity.ok(horarioAutobusesService.getAllHorarioAutobuses());
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<HorarioAutobuses>> listarPorId(@PathVariable ("id") Integer id){
        return ResponseEntity.ok(horarioAutobusesService.findById(id));

    }

    @PostMapping
    private ResponseEntity<HorarioAutobuses> guardar(@RequestBody HorarioAutobuses horarioAutobus){
        HorarioAutobuses tmp = horarioAutobusesService.create(horarioAutobus);

        try {
            return ResponseEntity.created(new URI("/api/horarioAutobus"+tmp.getAutobus_id())).body(tmp);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarHorarioAutobus(@RequestBody HorarioAutobuses horario_autobus){
        horarioAutobusesService.delete(horario_autobus);
        return ResponseEntity.ok().build();
    }


}