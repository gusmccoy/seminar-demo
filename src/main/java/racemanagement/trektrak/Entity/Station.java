package racemanagement.trektrak.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Station {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int eventId;
    private int number;
    private String stationName;
}
