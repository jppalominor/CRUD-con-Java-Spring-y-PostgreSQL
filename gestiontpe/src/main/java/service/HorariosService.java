package service;

import repository.HorariosRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Horarios;

@Service
public class HorariosService {

    @Autowired
    private HorariosRepository horariosRepository;

    public List<Horarios> getAllHorarios(){
        return horariosRepository.findAll();
    }

    public Optional<Horarios> findById(Integer id){
        return horariosRepository.findById(id);
    }
    
}
