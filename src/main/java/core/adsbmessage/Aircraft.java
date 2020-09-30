package core.adsbmessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aircraft {

    String aircraftICAO;
    String flightName;
    String aircraftType;

}
