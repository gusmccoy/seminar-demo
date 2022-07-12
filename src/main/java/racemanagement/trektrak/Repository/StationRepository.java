package racemanagement.trektrak.Repository;

import org.springframework.stereotype.Repository;
import racemanagement.trektrak.Entity.Station;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface StationRepository extends CrudRepository<Station, Integer> {
}
