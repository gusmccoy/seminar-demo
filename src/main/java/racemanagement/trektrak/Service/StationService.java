package racemanagement.trektrak.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.Entity.Station;
import racemanagement.trektrak.Repository.StationRepository;

@Service
public class StationService {
    private StationRepository stationRepository;

    public StationService(StationRepository repository) {
        this.stationRepository = repository;
    }

    public List<Station> getAllStations() {
        return (List<Station>) stationRepository.findAll();
    }

    public void saveNewStation(Station newStation) {
        stationRepository.save(newStation);
    }

    public void deleteStation(int id) {
        stationRepository.deleteById(id);
    }

    public void updateStation(Station updatedStation) {
        stationRepository.save(updatedStation);
    }
}
