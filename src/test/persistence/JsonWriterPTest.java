package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterPTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            SavedProfiles sp = new SavedProfiles("My Profile");
            JsonWriterP writer = new JsonWriterP("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptySavedProfiles() {
        try {
            SavedProfiles sp = new SavedProfiles("My Profile");
            JsonWriterP writer = new JsonWriterP("./data/testWriterEmptySavedProfiles.json");
            writer.open();
            writer.write(sp);
            writer.close();

            JsonReaderP reader = new JsonReaderP("./data/testWriterEmptySavedProfiles.json");
            sp = reader.read();
            assertEquals("My Profile", sp.getName());
//            assertEquals(0, wp.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralSavedProfiles() {
        try {
            SavedProfiles sp = new SavedProfiles("My Profile");
            sp.addToList(new Profile("Aleyna", 18, "Chad"));
            JsonWriterP writer = new JsonWriterP("./data/testWriterGeneralSavedProfiles.json");
            writer.open();
            writer.write(sp);
            writer.close();

            JsonReaderP reader = new JsonReaderP("./data/testWriterGeneralSavedProfiles.json");
            sp = reader.read();
            assertEquals("My Profile", sp.getName());
            List<Profile> profiles = sp.getSavedProfiles();
            assertEquals(1, profiles.size());
            checkProfile("Aleyna", 18, "Chad", profiles.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
