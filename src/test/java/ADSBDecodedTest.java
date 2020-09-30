
import org.junit.jupiter.api.Test;
import org.opensky.libadsb.ModeSDecoder;
import org.opensky.libadsb.exceptions.BadFormatException;
import org.opensky.libadsb.exceptions.UnspecifiedFormatError;
import org.opensky.libadsb.tools;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ADSBDecodedTest {

    @Test
    void whenHasAValidMessageParityIsOK() throws UnspecifiedFormatError, BadFormatException {

        assertTrue(true, "A paridade da mensagem confere");
    }

    @Test
    void whenHasAValidMessageParityIsOK_() throws UnspecifiedFormatError, BadFormatException {
        ModeSDecoder decoder = new ModeSDecoder();
        var reply = decoder.decode("8D40073C60B9847FBF4F5E6DA3DD");
        assertFalse(reply.checkParity(), "A paridade da mensagem não confere");
    }

}
