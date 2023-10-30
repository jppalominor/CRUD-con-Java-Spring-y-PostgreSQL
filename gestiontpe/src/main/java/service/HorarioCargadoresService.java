package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.HorarioCargadores;
import repository.HorarioCargadoresRepository;

@Service
public class HorarioCargadoresService {

    @Autowired
    private HorarioCargadoresRepository horarioCargadoresRepository;
    
    public HorarioCargadores create(HorarioCargadores horarioCargador){
        return horarioCargadoresRepository.save(horarioCargador);
    }

    public List<HorarioCargadores> getAllHorarioCargadores(){
        return horarioCargadoresRepository.findAll();
    }

    public Optional<HorarioCargadores> findById(Integer id){
        return horarioCargadoresRepository.findById(id);
        
    }

    public void delete(HorarioCargadores horarioCargador){
        horarioCargadoresRepository.delete(horarioCargador);

    }
}
