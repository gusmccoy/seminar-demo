package racemanagement.trektrak.Repository;

import org.springframework.stereotype.Repository;
import racemanagement.trektrak.Entity.ApplicationUser;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<ApplicationUser, Integer> {
    public List<ApplicationUser> findAllByUsernameAndPassword(String username, String password);
}
