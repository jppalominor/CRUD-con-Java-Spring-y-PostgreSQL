package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import models.Horarios;


public interface HorariosRepository extends JpaRepository<Horarios, Integer> {
    
}
