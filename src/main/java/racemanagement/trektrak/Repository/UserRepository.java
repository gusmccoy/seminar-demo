package racemanagement.trektrak.Repository;

import org.springframework.stereotype.Repository;
import racemanagement.trektrak.Entity.ApplicationUser;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<ApplicationUser, Integer> {
    public Optional<List<ApplicationUser>> findAllByUsername(String username);
}
