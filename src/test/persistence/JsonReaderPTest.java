package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderPTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReaderP reader = new JsonReaderP("./data/noSuchFile.json");
        try {
            SavedProfiles sp = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptySavedProfiles() {
        JsonReaderP reader = new JsonReaderP("./data/testReaderEmptySavedProfiles.json");
        try {
            SavedProfiles sp = reader.read();
            assertEquals("My Profile", sp.getName());
           // assertEquals(0, sp.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralSavedProfiles() {
        JsonReaderP reader = new JsonReaderP("./data/testReaderGeneralSavedProfiles.json");
        try {
            SavedProfiles sp = reader.read();
            assertEquals("My Profile", sp.getName());
            List<Profile> profiles = sp.getSavedProfiles();
            assertEquals(1, profiles.size());
            checkProfile("Aleyna", 18, "Chad", profiles.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
