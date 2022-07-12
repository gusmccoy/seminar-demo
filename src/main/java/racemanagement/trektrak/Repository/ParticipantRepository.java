package racemanagement.trektrak.Repository;

import org.springframework.stereotype.Repository;
import racemanagement.trektrak.Entity.Participant;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Integer> {
}
