package racemanagement.trektrak.Repository;

import org.springframework.stereotype.Repository;
import racemanagement.trektrak.Entity.StationCheckIn;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface StationCheckInRepository extends CrudRepository<StationCheckIn, Integer> {
    public Optional<List<StationCheckIn>> findAllByEventId(int eventId); 
}
