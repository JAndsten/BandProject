package fi.haagahelia.BandProject.domain;

import org.springframework.data.repository.CrudRepository;

public interface BandRepository extends CrudRepository<Band, Long> {
    
}