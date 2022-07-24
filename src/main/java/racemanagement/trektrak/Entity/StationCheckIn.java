package racemanagement.trektrak.Entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import racemanagement.trektrak.DTO.CheckInDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StationCheckIn {

    public StationCheckIn(CheckInDTO checkInDTO) {
        id = checkInDTO.getId();
        bib = checkInDTO.getBib();
        eventId = checkInDTO.getEventId();
        stationId = checkInDTO.getStationNumber();

        if(checkInDTO.getTimestamp() == null) {
            checkInTime = new Date();
        }
        else {
            checkInTime = checkInDTO.getTimestamp();
        }
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int bib;
    private int stationId;
    private int eventId;
    private Date checkInTime;
}
