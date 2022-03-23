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
        assertEquals(4, testProfile.getSkillLevel());
    }


}