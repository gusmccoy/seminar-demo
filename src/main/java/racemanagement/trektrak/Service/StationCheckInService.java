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

    public List<CheckInDTO> getAllStationCheckInsByEventId(int eventId) {
        var checkIns = stationCheckInRepository.findAllByEventId(eventId);
        var checkInDTOs = new ArrayList<CheckInDTO>();
        if(checkIns.isPresent() && !checkIns.get().isEmpty()) {
            checkIns.get().forEach(e -> {
                checkInDTOs.add(new CheckInDTO(e));
            });
        }
        return checkInDTOs;
    }

    public List<CheckInDTO> getAllStationCheckInsByEventAndStation(int eventId, int stationId) {
        var checkIns = stationCheckInRepository.findAllByEventIdAndStationId(eventId, stationId);
        var checkInDTOs = new ArrayList<CheckInDTO>();
        if(checkIns.isPresent() && !checkIns.get().isEmpty()) {
            checkIns.get().forEach(e -> {
                checkInDTOs.add(new CheckInDTO(e));
            });
        }
        return checkInDTOs;
    }

    public int saveNewStationCheckIn(CheckInDTO newStationCheckIn) {
        return stationCheckInRepository.save(new StationCheckIn(newStationCheckIn)).getId();
    }

    public void deleteStationCheckIn(int id) {
        stationCheckInRepository.deleteById(id);
    }

    public void updateStationCheckIn(CheckInDTO updatedStationCheckIn) {
        stationCheckInRepository.save(new StationCheckIn(updatedStationCheckIn));
    }
}
