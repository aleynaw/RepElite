package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    private Profile testProfile;

    @BeforeEach
    void runBefore() { testProfile = new Profile("Jane Doe", 25, "Chad");}

    @Test
    void testConstructor(){
        assertEquals("Jane Doe", testProfile.getName());
        assertEquals(25, testProfile.getAge());
        assertEquals("Chad", testProfile.getSkillLevel());
    }


}