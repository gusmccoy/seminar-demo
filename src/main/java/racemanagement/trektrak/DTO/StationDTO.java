package racemanagement.trektrak.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationDTO {
    private int id;
    private int eventId;
    private int stationNumber;
    private String name;
}
