package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HorarioAutobusesRepository;
import models.HorarioAutobuses;

@Service
public class HorarioAutobusesService { 
    
    @Autowired
    private HorarioAutobusesRepository horarioAutobusesRepository;


    public HorarioAutobuses create(HorarioAutobuses horario_autobus){
        return horarioAutobusesRepository.save(horario_autobus);
    }

    public List<HorarioAutobuses> getAllHorarioAutobuses(){
        return horarioAutobusesRepository.findAll();
    }

    public Optional<HorarioAutobuses> findById(Integer id){
        return horarioAutobusesRepository.findById(id);
    }

    public void delete(HorarioAutobuses horario_autobus){
        horarioAutobusesRepository.delete(horario_autobus);
    }
}

