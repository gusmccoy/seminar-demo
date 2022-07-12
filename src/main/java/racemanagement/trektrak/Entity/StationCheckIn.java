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
        bib = checkInDTO.getBib();
        eventId = checkInDTO.getEventId();
        checkInTime = new Date();
        stationId = checkInDTO.getStationNumber();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int bib;
    private int stationId;
    private int eventId;
    private Date checkInTime;
}
