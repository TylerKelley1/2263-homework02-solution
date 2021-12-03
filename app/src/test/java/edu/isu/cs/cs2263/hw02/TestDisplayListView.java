/**
 * @Author Tyler Kelley
 * CS 2263 Homework 3
 * Due 11/19/2021
 * Griffith
 */
package edu.isu.cs.cs2263.hw02;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeoutException;

import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(MockitoExtension.class)
public class TestDisplayListView extends ApplicationTest {
    /**
     * Variables with javaFX ID's so we can call them in our tests
     */
    final String listCourses = "#lstCourses";
    final String labelCourses = "Courses";
    final String buttonDisplay = "Display (dept.)";

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
     * Tests that when we click on the Display button on the main view a label with Courses is above the list of courses
     */
    @Test
    public void testLabelCourses(){
        verifyThat(buttonDisplay, NodeMatchers.isNotNull());
        clickOn(buttonDisplay);
        verifyThat(labelCourses, NodeMatchers.isNotNull());
        Label testLabel = find(labelCourses);
        assertEquals("Courses", testLabel.getText());
    }

    /**
     * Test that our list view actually has items that can be displayed but in this specific test it doesn't have any courses
     * added to the list thus the size of the list should be 0
     */
    @Test
    public void testListView(){
        verifyThat(buttonDisplay, NodeMatchers.isNotNull());
        clickOn(buttonDisplay);
        verifyThat(listCourses, NodeMatchers.isNotNull());
        ListView testList = find(listCourses);
        assertEquals(0, testList.getId().length());
    }



}
