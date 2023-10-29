package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Cargadores;
import repository.CargadoresRepository;

@Service
public class CargadoresService {

    @Autowired
    private CargadoresRepository cargadoresRepository;

    public Cargadores create (Cargadores cargador){
        return cargadoresRepository.save(cargador);
    }

    public List<Cargadores> getAllCargadores(){
        return cargadoresRepository.findAll();    
    }

    public void delete (Cargadores cargador){
        cargadoresRepository.delete(cargador);
    }

    public Optional<Cargadores> findById(Integer id){
        return cargadoresRepository.findById(id);
    }
    
}
