package racemanagement.trektrak.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.DTO.CheckInDTO;
import racemanagement.trektrak.Entity.StationCheckIn;
import racemanagement.trektrak.Repository.StationCheckInRepository;

@Service
public class StationCheckInService {
    private StationCheckInRepository stationCheckInRepository;

    public StationCheckInService(StationCheckInRepository repository) {
        this.stationCheckInRepository = repository;
    }

    public List<CheckInDTO> getAllStationCheckIns() {
        var checkIns = (List<StationCheckIn>) stationCheckInRepository.findAll();
        var checkInDTOs = new ArrayList<CheckInDTO>();
        checkIns.forEach(e -> {
            checkInDTOs.add(new CheckInDTO(e));
        });
        return checkInDTOs;
    }

    public void saveNewStationCheckIn(CheckInDTO newStationCheckIn) {
        stationCheckInRepository.save(new StationCheckIn(newStationCheckIn));
    }

    public void deleteStationCheckIn(int id) {
        stationCheckInRepository.deleteById(id);
    }

    public void updateStationCheckIn(CheckInDTO updatedStationCheckIn) {
        stationCheckInRepository.save(new StationCheckIn(updatedStationCheckIn));
    }
}
