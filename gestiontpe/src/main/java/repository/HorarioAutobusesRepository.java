package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import models.HorarioAutobuses;

public interface HorarioAutobusesRepository extends JpaRepository<HorarioAutobuses, Integer> {
    
}
