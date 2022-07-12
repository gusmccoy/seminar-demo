package racemanagement.trektrak.Controller;

import org.springframework.web.bind.annotation.RestController;

import racemanagement.trektrak.DTO.CheckInDTO;
import racemanagement.trektrak.Service.StationCheckInService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "https://www.trek-trak.gusmccoy.dev"})
@RestController
public class StationCheckInController {

    private StationCheckInService stationCheckInService;

    public StationCheckInController(StationCheckInService stationCheckInService) {
        this.stationCheckInService = stationCheckInService;
    }

    @GetMapping("/stationCheckIn/all")
	public List<CheckInDTO> getAllStationCheckIns() {
		return stationCheckInService.getAllStationCheckIns();
	}

    @PostMapping("/stationCheckIn/new")
    public void saveNewStationCheckIn(@RequestBody CheckInDTO newStationCheckIn) {
        stationCheckInService.saveNewStationCheckIn(newStationCheckIn);
    }

    @DeleteMapping("/stationCheckIn/delete/{id}")
    public void deleteStationCheckIn(@PathVariable int id) {
        stationCheckInService.deleteStationCheckIn(id);
    }

    @PutMapping("/stationCheckIn/update")
    public void updateStationCheckIn(@RequestBody CheckInDTO updatedStationCheckIn) {
        stationCheckInService.updateStationCheckIn(updatedStationCheckIn);
    }
}
