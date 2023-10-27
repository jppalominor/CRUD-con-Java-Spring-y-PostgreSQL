package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Autobuses;
import repository.AutobusesRepository;

@Service
public class AutobusesService {
    
    @Autowired
    private AutobusesRepository autobusesRepository;

    public Autobuses create (Autobuses autobus){
        return autobusesRepository.save(autobus);
    }

    public List<Autobuses> getAllAutobuses(){
        return autobusesRepository.findAll();    
    }

    public void delete (Autobuses autobus){
        autobusesRepository.delete(autobus);
    }

    public Optional<Autobuses> findById(Integer id){
        return autobusesRepository.findById(id);
    }
}
