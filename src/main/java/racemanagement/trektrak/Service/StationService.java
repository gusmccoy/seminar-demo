package racemanagement.trektrak.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.DTO.StationDTO;
import racemanagement.trektrak.Entity.Station;
import racemanagement.trektrak.Repository.StationRepository;

@Service
public class StationService {
    private StationRepository stationRepository;

    public StationService(StationRepository repository) {
        this.stationRepository = repository;
    }

    public List<StationDTO> getAllStations() {
        var stations = (List<Station>) stationRepository.findAll();
        var stationDTOs = new ArrayList<StationDTO>();
        stations.forEach(e -> {
            stationDTOs.add(new StationDTO(e.getId(), e.getEventId(), e.getNumber(), e.getStationName()));
        });
        return stationDTOs;
    }

    public List<StationDTO> getAllStationsByEventId(int eventId) {
        var stations = stationRepository.findAllByEventId(eventId);
        var stationDTOs = new ArrayList<StationDTO>();
        if(stations.isPresent() && !stations.get().isEmpty()) {
            stations.get().forEach(e -> {
                stationDTOs.add(new StationDTO(e.getId(), e.getEventId(), e.getNumber(), e.getStationName()));
            });
        }
        return stationDTOs;
    }

    public void saveNewStation(StationDTO newStation) {
        var station = Station.builder()
            .eventId(newStation.getEventId())
            .stationName(newStation.getName())
            .number(newStation.getStationNumber())
            .build();
        stationRepository.save(station);
    }

    public void deleteStation(int id) {
        stationRepository.deleteById(id);
    }

    public void updateStation(StationDTO updatedStation) {
        var station = Station.builder()
            .eventId(updatedStation.getEventId())
            .stationName(updatedStation.getName())
            .build();
        stationRepository.save(station);
    }
}
