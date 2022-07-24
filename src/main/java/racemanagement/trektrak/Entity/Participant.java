package racemanagement.trektrak.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import racemanagement.trektrak.DTO.ParticipantDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Participant {

    public Participant (ParticipantDTO participant) {
        id = participant.getId();
        bib = participant.getBib();
        firstName = participant.getFirstName();
        lastName = participant.getLastName();
        eventId = participant.getEventId();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int bib;
    private int eventId;
    private String firstName;
    private String lastName;
}
