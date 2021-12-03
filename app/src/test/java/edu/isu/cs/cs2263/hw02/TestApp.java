/**
 * @Author Tyler Kelley
 * CS 2263 Homework 3
 * Due 11/19/2021
 * Griffith
 */
package edu.isu.cs.cs2263.hw02;

import edu.isu.cs.cs2263.hw02.data.Course;
import edu.isu.cs.cs2263.hw02.views.AppView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import java.util.concurrent.TimeoutException;


@ExtendWith(MockitoExtension.class)
public class TestApp extends ApplicationTest {

    /**
     * ID string variables that will be used as ID string for the find method in order to find certain buttons, labels
     * alerts, lists, etc.
     */
    final String buttonDept = "Display (dept.)";
    final String buttonNewCourse = "New Course";
    final String buttonExit = "Exit";
    final String alertExit = "Confirmation";
    final String labelDept = "Departments: ";
    final String choiceBox = "#Depts";

    /**
     * Before testing start the application that we want to test
     * @throws Exception
     */
    @Before
    public void setUpClass() throws Exception {
        ApplicationTest.launch(App.class);
    }

    /**
     * Show the stage that we are going to test
     * @param stage
     */
    @Override
    public void start(Stage stage) throws Exception{
        stage.show();
    }

    /**
     * After testing hide the current stage
     * @throws TimeoutException
     */
    @After
    public void afterEachTest() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    /**
     * Be able to find labels, buttons, lists, etc. with a provided query string
     * @param query
     * @param <T>
     * @return
     */
    public <T extends Node> T find(final String query){
        return (T) lookup(query).queryAll().iterator().next();
    }

    /**
     * Tests that the app constructor properly populates all scenes and appviews as well as an empty course vector that can
     * be added on to later
     */
    @Test
    public void testApp(){
        App test = new App();
        assertNull(test.getCourses(),"Welcome view is currently being stored in the Appview and a new " +
                "courses vector is properly added so the user can add courses in the UI but is should be null since" +
                "no classes are added yet");
    }

    /**
     * Tests that the department button is appearing on the home screen
     */
    @Test
    public void testButtonDept(){
        verifyThat(buttonDept, NodeMatchers.isNotNull());
        Button testButton = find(buttonDept);
        assertEquals("Display (dept.)",testButton.getText());
    }

    /**
     * Tests that the new course button is properly appearing on the home screen of the window
     */
    @Test
    public void testButtonNewCourse(){
        verifyThat(buttonNewCourse, NodeMatchers.isNotNull());
        Button testButton = find(buttonNewCourse);
        assertEquals("New Course",testButton.getText());
    }

    /**
     * Tests that the exit button is properly appearing on the home screen of the window
     */
    @Test
    public void testButtonExit(){
        verifyThat(buttonExit, NodeMatchers.isNotNull());
        Button testButton = find(buttonExit);
        assertEquals("Exit",testButton.getText());
    }

    /**
     * Tests that when you click on the exit button a prompt shows up asking that you are sure you want to exit
     */
    @Test
    public void testClickExit(){
        verifyThat(buttonExit, NodeMatchers.isNotNull());
        Button testButton = find(buttonExit);
        clickOn(testButton);
        verifyThat(alertExit, NodeMatchers.isNotNull());
        Node testAlert = find(alertExit);
        assertEquals("Confirmation", testAlert.getId());
    }

    /**
     * Tests that the Departments label is actually showing on the main screen
     */
    @Test
    public void testDeptLabel(){
        verifyThat(labelDept, NodeMatchers.isNotNull());
        Label testLabel = find(labelDept);
        assertEquals("Departments: ",testLabel.getText());
    }

    /**
     * Test that shows the current app view is different when first created than when we call show course form method
     * which changes the app view to the CourseForm ID
     */
    @Test
    public void testCourseForm(){
        App test = new App();
        AppView firstTest = test.getCurrentView();
        test.showCourseForm();
        assertNotEquals(firstTest,test.getCurrentView());
    }

    /**
     * Test which is the same above except with the display list ID which should be different from the main
     * appview when you load into javafx
     */
    @Test
    public void testDisplayList(){
        App test = new App();
        AppView firstTest = test.getCurrentView();
        test.displayList();
        assertNotEquals(firstTest,test.getCurrentView());
    }

    /**
     * Test that shows when show welcome method is called the current view of appview is then changed to the welcome ID
     * view
     */
    @Test
    public void testShowWelcome(){
        App test = new App();
        AppView firstTest = test.getCurrentView();
        test.showWelcome();
        assertNotEquals(firstTest,test.getCurrentView());
    }

    /**
     * Tests that we can properly add a course into the courses vector
     */
    @Test
    public void testAddCourse(){
        Course testCourse = new Course("Test" , "1000" , 1150 , 3);
        App test = new App();
        test.addCourse(testCourse);
        assertEquals("Test", test.getCourses().get(0).getName());
    }

    /**
     * Test to make sure our list box is showing on the main screen with a total of 6 selection of departments
     * showing underneath the choice box
     */
    @Test
    public void testChoiceBox(){
        verifyThat(choiceBox, NodeMatchers.isNotNull());
        assertEquals(5,choiceBox.length());
    }

    /**
     * Tests that when we click on the choice box of depts the correct index is returned from the get selected
     * department method inside of App
     */
    @Test
    public void testDeptSel(){
        App test = new App();
        verifyThat(choiceBox, NodeMatchers.isNotNull());
        clickOn(choiceBox);
        clickOn(String.valueOf(choiceBox.indexOf("Computer Science (CS)")));
        assertEquals(0,test.getSelectedDepartment());

    }



}
