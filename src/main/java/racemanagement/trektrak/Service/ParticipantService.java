package racemanagement.trektrak.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.Entity.Participant;
import racemanagement.trektrak.Repository.ParticipantRepository;

@Service
public class ParticipantService {
    private ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository repository) {
        this.participantRepository = repository;
    }

    public List<Participant> getAllParticipants() {
        return (List<Participant>) participantRepository.findAll();
    }

    public void saveNewParticipant(Participant newParticipant) {
        participantRepository.save(newParticipant);
    }

    public void deleteParticipant(int id) {
        participantRepository.deleteById(id);
    }

    public void updateParticipant(Participant updatedParticipant) {
        participantRepository.save(updatedParticipant);
    }
}
