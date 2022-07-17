package racemanagement.trektrak.Repository;

import org.springframework.stereotype.Repository;
import racemanagement.trektrak.Entity.Station;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface StationRepository extends CrudRepository<Station, Integer> {
    public Optional<List<Station>> findAllByEventId(int eventId); 
}
