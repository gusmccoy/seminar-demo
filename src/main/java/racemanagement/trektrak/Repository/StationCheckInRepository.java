package racemanagement.trektrak.Repository;

import org.springframework.stereotype.Repository;
import racemanagement.trektrak.Entity.StationCheckIn;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface StationCheckInRepository extends CrudRepository<StationCheckIn, Integer> {
}
