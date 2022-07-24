package racemanagement.trektrak.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import racemanagement.trektrak.Entity.Participant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO {

    public ParticipantDTO (Participant participant) {
        id = participant.getId();
        bib = participant.getBib();
        firstName = participant.getFirstName();
        lastName = participant.getLastName();
        eventId = participant.getEventId();
    }

    private int id;
    private int bib;
    private int eventId;
    private String firstName;
    private String lastName;
}
