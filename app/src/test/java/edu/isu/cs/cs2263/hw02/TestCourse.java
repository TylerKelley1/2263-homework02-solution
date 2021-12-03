/**
 * @Author Tyler Kelley
 * CS 2263 Homework 3
 * Due 11/19/2021
 * Griffith
 */
package edu.isu.cs.cs2263.hw02;
import edu.isu.cs.cs2263.hw02.data.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestCourse {
    @Mock
    Course testCourse;
    /**
     * Helper method that auto generates the same Course object for every test
     * @return testCourse Course object
     */
    @BeforeEach
    public void generate(){
        this.testCourse = new Course("Tyler","Test",100,3);
    }

    /**
     * test that the test constructor actually creates an course object with expected values
     */
    @Test
    void test_Course(){
        assertNotNull(testCourse);
    }

    /**
     * Test that the get number returns the correct value after generating the testCourse object
     */
    @Test
    void test_GetNumber(){
        assertEquals(100, testCourse.getNumber());
    }
    /**
     * Test that the set number method actually changes the number
     */
    @Test
    void test_SetNumber(){
        testCourse.setNumber(50);
        assertEquals(50, testCourse.getNumber());
    }

    /**
     * Test that the get name method actually returns the correct name variable from the course class
     */
    @Test
    void test_GetName(){
        assertEquals("Tyler", testCourse.getName());
    }
    /**
     * Test that the set name method changes the name of the course correctly
     */
    @Test
    void test_SetName(){
        testCourse.setName("Ty");
        assertEquals("Ty", testCourse.getName());
    }
    /**
     * Test that the get credits method returns the correct amount of credits passed for each course
     */
    @Test
    void test_GetCredits(){
        assertEquals(3,testCourse.getCredits());
    }
    /**
     * Test that the set credits methods changes the amount of credits each class has
     */
    @Test
    void test_SetCredits(){
        testCourse.setCredits(4);
        assertEquals(4, testCourse.getCredits());
    }
    /**
     * Test that the get code method returns the correct code for each class
     */
    @Test
    void test_GetCode(){
        assertEquals("Test", testCourse.getCode());
    }
    /**
     * Test that the set code method correctly changes the code of the class
     */
    @Test
    void test_SetCode(){
        testCourse.setCode("MoreTests");
        assertEquals("MoreTests", testCourse.getCode());
    }
    /**
     * Test that the to string method generates a string containing the variables inside of the course class
     */
    @Test
    void test_ToString(){
        assertNotNull(testCourse.toString());
    }
}
