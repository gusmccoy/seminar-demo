package racemanagement.trektrak.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.Entity.StationCheckIn;
import racemanagement.trektrak.Repository.StationCheckInRepository;

@Service
public class StationCheckInService {
    private StationCheckInRepository stationCheckInRepository;

    public StationCheckInService(StationCheckInRepository repository) {
        this.stationCheckInRepository = repository;
    }

    public List<StationCheckIn> getAllStationCheckIns() {
        return (List<StationCheckIn>) stationCheckInRepository.findAll();
    }

    public void saveNewStationCheckIn(StationCheckIn newStationCheckIn) {
        stationCheckInRepository.save(newStationCheckIn);
    }

    public void deleteStationCheckIn(int id) {
        stationCheckInRepository.deleteById(id);
    }

    public void updateStationCheckIn(StationCheckIn updatedStationCheckIn) {
        stationCheckInRepository.save(updatedStationCheckIn);
    }
}
