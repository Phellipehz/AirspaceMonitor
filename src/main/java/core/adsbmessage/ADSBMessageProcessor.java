package core.adsbmessage;

import org.opensky.libadsb.ModeSDecoder;
import org.opensky.libadsb.Position;
import org.opensky.libadsb.exceptions.BadFormatException;
import org.opensky.libadsb.exceptions.UnspecifiedFormatError;
import org.opensky.libadsb.msgs.AirbornePositionV0Msg;
import org.opensky.libadsb.tools;

import static org.opensky.libadsb.msgs.ModeSReply.subtype.ADSB_AIRBORN_POSITION_V2;

public class ADSBMessageProcessor {

    ModeSDecoder decoder = new ModeSDecoder();

    ADSBRegistry process(String message) throws UnspecifiedFormatError, BadFormatException {
        var registry = new ADSBRegistry();
        var reply = decoder.decode(message);
        String icao24 = tools.toHexString(reply.getIcao24());

        registry.aircraft = new Aircraft();
        registry.aircraft.aircraftICAO = icao24;

        switch (reply.getType()) {
            case ADSB_AIRBORN_POSITION_V0:
            case ADSB_AIRBORN_POSITION_V1:
            case ADSB_AIRBORN_POSITION_V2:
                AirbornePositionV0Msg airbornePosition0 = (AirbornePositionV0Msg) reply;
                airbornePosition0.getAltitude();
                airbornePosition0.getLocalPosition(Position.fromECEF(0,0,0));
        }

        return registry;
    }


}
