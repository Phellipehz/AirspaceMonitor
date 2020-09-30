package core.adsbmessage;

import lombok.Data;

@Data
public class AirbornePosition {

    double altitude;
    double latitude;
    double longitude;

    double head;
    double climb;

}
