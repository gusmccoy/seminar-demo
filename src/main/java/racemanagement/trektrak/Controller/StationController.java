package racemanagement.trektrak.Controller;

import org.springframework.web.bind.annotation.RestController;

import racemanagement.trektrak.Entity.Station;
import racemanagement.trektrak.Service.StationService;

import java.util.ArrayList;
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
public class StationController {

    private StationService stationService;

    List<Station> stations = new ArrayList<Station>();

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/station/all")
	public List<Station> getAllStations() {
        System.out.print("Retrieving All Exisiting Stations...");
		return stationService.getAllStations();
	}

    @PostMapping("/station/new")
    public void saveNewStation(@RequestBody Station newStation) {
        stationService.saveNewStation(newStation);
    }

    @DeleteMapping("/station/delete/{id}")
    public void deleteStation(@PathVariable int id) {
        System.out.println("Deleting Station by ID: ID = " + id);
        stationService.deleteStation(id);
    }

    @PutMapping("/station/update")
    public void updateStation(@RequestBody Station updatedStation) {
        stationService.updateStation(updatedStation);
    }
}
