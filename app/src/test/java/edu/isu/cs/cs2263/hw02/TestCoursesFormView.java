/**
 * @Author Tyler Kelley
 * CS 2263 Homework 3
 * Due 11/19/2021
 * Griffith
 */
package edu.isu.cs.cs2263.hw02;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(MockitoExtension.class)
public class TestCoursesFormView extends ApplicationTest {

    /**
     * String ID's of each button and label so that the find method of our robot can find the certain javaFX element
     */
    final String buttonNewCourse = "New Course";
    final String buttonReset = "Reset";
    final String buttonAdd = "Add Course";
    final String buttonDisplay = "Display (dept.)";
    final String labelName = "Name:";
    final String labelNumber = "Number:";
    final String labelCredits = "Credits:";
    final String labelNew = "Create New Course";
    final String textField = "Enter a course name...";

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
     * Test that when we click the new course button a reset button will pop up
     */
    @Test
    public void testClickNewCourseWithReset(){
        verifyThat(buttonNewCourse, NodeMatchers.isNotNull());
        clickOn(buttonNewCourse);
        verifyThat(buttonReset, NodeMatchers.isNotNull());
        Button testButton = find(buttonReset);
        assertEquals("Reset", testButton.getText());
    }
    /**
     * Test that when we click the new course button an add button will pop up
     */
    @Test
    public void testClickNewCourseWithAdd(){
        verifyThat(buttonNewCourse, NodeMatchers.isNotNull());
        clickOn(buttonNewCourse);
        verifyThat(buttonAdd, NodeMatchers.isNotNull());
        Button testButton = find(buttonAdd);
        assertEquals("Add Course", testButton.getText());
    }
    /**
     * Test that when we click the new course button a label with Name: will be on the screen
     */
    @Test
    public void testClickNewCourseWithName(){
        verifyThat(buttonNewCourse, NodeMatchers.isNotNull());
        clickOn(buttonNewCourse);
        verifyThat(labelName, NodeMatchers.isNotNull());
        Label testLabel = find(labelName);
        assertEquals("Name:", testLabel.getText());
    }
    /**
     * Test that when we click the new course button a label with Number: will be on the screen
     */
    @Test
    public void testClickNewCourseWithNumber(){
        verifyThat(buttonNewCourse, NodeMatchers.isNotNull());
        clickOn(buttonNewCourse);
        verifyThat(labelNumber, NodeMatchers.isNotNull());
        Label testLabel = find(labelNumber);
        assertEquals("Number:", testLabel.getText());
    }
    /**
     * Test that when we click the new course button a label with Credits: will be on the screen
     */
    @Test
    public void testClickNewCourseWithCredits(){
        verifyThat(buttonNewCourse, NodeMatchers.isNotNull());
        clickOn(buttonNewCourse);
        verifyThat(labelCredits, NodeMatchers.isNotNull());
        Label testLabel = find(labelCredits);
        assertEquals("Credits:", testLabel.getText());
    }
    /**
     * Test that when we click the new course button a label with Create new course will be on the screen
     */
    @Test
    public void testClickNewCourseWithCreate(){
        verifyThat(buttonNewCourse, NodeMatchers.isNotNull());
        clickOn(buttonNewCourse);
        verifyThat(labelNew, NodeMatchers.isNotNull());
        Label testLabel = find(labelNew);
        assertEquals("Create New Course", testLabel.getText());
    }

    /**
     * Test that a text field is available to type in course names after we press the new course button
     */
    @Test
    public void testAddingCourse(){
        verifyThat(buttonNewCourse, NodeMatchers.isNotNull());
        clickOn(buttonNewCourse);
        verifyThat(textField, NodeMatchers.isNotNull());
        TextField testField = find(textField);
        assertEquals("Enter a Course Name...", testField.getText());
    }

    /**
     * Test that we can properly add a course that will be displayed in the text field under the display button
     */
    @Test
    public void testAddingCourseWithText() {
        verifyThat(buttonNewCourse, NodeMatchers.isNotNull());
        clickOn(buttonNewCourse);
        verifyThat(textField, NodeMatchers.isNotNull());
        clickOn(textField);
        type(KeyCode.valueOf("Test Class"));
        verifyThat(buttonAdd, NodeMatchers.isNotNull());
        clickOn(buttonAdd);
        verifyThat(buttonDisplay, NodeMatchers.isNotNull());
        clickOn(buttonDisplay);
        verifyThat(textField, NodeMatchers.isNotNull());
        TextField testText = find(textField);
        assertNotNull(testText.getText());
    }

}
