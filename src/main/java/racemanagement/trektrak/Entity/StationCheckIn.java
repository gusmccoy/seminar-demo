package racemanagement.trektrak.Entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StationCheckIn {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int bib;
    private int eventId;
    private Date checkInTime;
}
