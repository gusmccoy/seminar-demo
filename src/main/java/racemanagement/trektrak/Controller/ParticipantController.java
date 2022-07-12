package racemanagement.trektrak.Controller;

import org.springframework.web.bind.annotation.RestController;

import racemanagement.trektrak.Entity.Participant;
import racemanagement.trektrak.Service.ParticipantService;

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
public class ParticipantController {

    private ParticipantService participantService;

    List<Participant> participants = new ArrayList<Participant>();

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/participant/all")
	public List<Participant> getAllParticipants() {
        System.out.print("Retrieving All Exisiting Participants...");
		return participantService.getAllParticipants();
	}

    @PostMapping("/participant/new")
    public void saveNewParticipant(@RequestBody Participant newParticipant) {
        participantService.saveNewParticipant(newParticipant);
    }

    @DeleteMapping("/participant/delete/{id}")
    public void deleteParticipant(@PathVariable int id) {
        System.out.println("Deleting Participant by ID: ID = " + id);
        participantService.deleteParticipant(id);
    }

    @PutMapping("/participant/update")
    public void updateParticipant(@RequestBody Participant updatedParticipant) {
        participantService.updateParticipant(updatedParticipant);
    }
}
