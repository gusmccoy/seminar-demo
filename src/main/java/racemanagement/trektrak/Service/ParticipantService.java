package racemanagement.trektrak.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.DTO.ParticipantDTO;
import racemanagement.trektrak.Entity.Participant;
import racemanagement.trektrak.Repository.ParticipantRepository;

@Service
public class ParticipantService {
    private ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository repository) {
        this.participantRepository = repository;
    }

    public List<ParticipantDTO> getAllParticipants() {
        var participants = (List<Participant>) participantRepository.findAll();
        var participantDTOs = new ArrayList<ParticipantDTO>();
        participants.forEach(e -> {
            participantDTOs.add(new ParticipantDTO(e));
        });
        return participantDTOs;
    }

    public List<ParticipantDTO> getAllParticipantsByEventId(int eventId) {
        var participants = participantRepository.findAllByEventId(eventId);
        var participantDTOs = new ArrayList<ParticipantDTO>();
        if(participants.isPresent() && !participants.get().isEmpty()) {
            participants.get().forEach(e -> {
                participantDTOs.add(new ParticipantDTO(e));
            });
        }
        return participantDTOs;
    }

    public int saveNewParticipant(ParticipantDTO newParticipant) {
        return participantRepository.save(new Participant(newParticipant)).getId();
    }

    public void deleteParticipant(int id) {
        participantRepository.deleteById(id);
    }

    public void updateParticipant(ParticipantDTO updatedParticipant) {
        participantRepository.save(new Participant(updatedParticipant));
    }
}
