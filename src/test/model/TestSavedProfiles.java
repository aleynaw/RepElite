package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.TrackerApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSavedProfiles {
    private SavedProfiles testSavedProfiles;
    private Profile testProfile;

    @BeforeEach
    void runBefore() {
        testSavedProfiles = new SavedProfiles("New Profiles");
    }

    @Test
    void testConstructor() {
        assertTrue(testSavedProfiles.getSavedProfiles().isEmpty());
    }

    @Test
    void testAddToProfilesJustProfile() {
        testProfile = new Profile("Jane Doe", 25, "Chad");
        testSavedProfiles.addToList(testProfile);
    }

    @Test
    void testAddToProfilesBoth() {
        testProfile = new Profile("Jane Doe", 25, "Chad");
        SavedProfiles.addToList(testSavedProfiles, testProfile);
    }

    @Test
    void testAssignValues() {
        testProfile = new Profile("Jane Doe", 25, "Chad");
        SavedProfiles.addToList(testSavedProfiles, testProfile);
        SavedProfiles.assignValues(testSavedProfiles);
        assertEquals(TrackerApp.getProf().getName(), testSavedProfiles.savedProfileArray.get(0).getName());
        assertEquals(TrackerApp.getProf().getAge(), testSavedProfiles.savedProfileArray.get(0).getAge());
        assertEquals(TrackerApp.getProf().getSkillLevel(), testSavedProfiles.savedProfileArray.get(0).getSkillLevel());


    }
}
