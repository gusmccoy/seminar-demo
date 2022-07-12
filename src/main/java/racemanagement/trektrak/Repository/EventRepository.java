package racemanagement.trektrak.Repository;

import org.springframework.stereotype.Repository;
import racemanagement.trektrak.Entity.Event;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
