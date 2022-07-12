package racemanagement.trektrak.Controller;

import org.springframework.web.bind.annotation.RestController;

import racemanagement.trektrak.DTO.ParticipantDTO;
import racemanagement.trektrak.Service.ParticipantService;

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

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/participant/all")
	public List<ParticipantDTO> getAllParticipants() {
		return participantService.getAllParticipants();
	}

    @PostMapping("/participant/new")
    public void saveNewParticipant(@RequestBody ParticipantDTO newParticipant) {
        participantService.saveNewParticipant(newParticipant);
    }

    @DeleteMapping("/participant/delete/{id}")
    public void deleteParticipant(@PathVariable int id) {
        participantService.deleteParticipant(id);
    }

    @PutMapping("/participant/update")
    public void updateParticipant(@RequestBody ParticipantDTO updatedParticipant) {
        participantService.updateParticipant(updatedParticipant);
    }
}
