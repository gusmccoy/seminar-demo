package racemanagement.trektrak.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import racemanagement.trektrak.Entity.StationCheckIn;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInDTO {

    public CheckInDTO(StationCheckIn checkIn) {
        eventId = checkIn.getEventId();
        stationNumber = checkIn.getStationId();
        bib = checkIn.getBib();
        timestamp = checkIn.getCheckInTime();
    }

    private int eventId;
    private int stationNumber;
    private int bib;
    private Date timestamp;
}
