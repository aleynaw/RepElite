package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

//test suite for profile
class ProfileTest {
    private Profile testProfile;

    @BeforeEach
    void runBefore() { testProfile = new Profile("Jane Doe", 25, 4);}

    @Test
    void testConstructor(){
        assertEquals("Jane Doe", testProfile.getName());
        assertEquals(25, testProfile.getAge());
        assertEquals("4 - Chad", testProfile.getSkillLevel());
    }

    @Test
    void testGetSkillLevel() {
        Profile testP1 = new Profile("JD", 25, 1);
        assertEquals("1 - Beginner", testP1.getSkillLevel());
        assertEquals(1, testP1.getSkillLevelInt());

        Profile testP2 = new Profile("JD", 25, 2);
        assertEquals("2 - Intermediate", testP2.getSkillLevel());
        assertEquals(2, testP2.getSkillLevelInt());

        Profile testP3 = new Profile("JD", 25, 3);
        assertEquals("3 - Advanced", testP3.getSkillLevel());
        assertEquals(3, testP3.getSkillLevelInt());
    }


}