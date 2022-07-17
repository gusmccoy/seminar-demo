package racemanagement.trektrak.Repository;

import org.springframework.stereotype.Repository;
import racemanagement.trektrak.Entity.Participant;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Integer> {
    public Optional<List<Participant>> findAllByEventId(int eventId);
}
