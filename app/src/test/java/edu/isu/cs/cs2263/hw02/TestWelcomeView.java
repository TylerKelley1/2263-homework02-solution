/**
 * @Author Tyler Kelley
 * CS 2263 Homework 3
 * Due 11/19/2021
 * Griffith
 */
package edu.isu.cs.cs2263.hw02;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.framework.junit.ApplicationTest;
import javafx.scene.control.Label;
import javafx.scene.Node;


import java.util.concurrent.TimeoutException;

@ExtendWith(MockitoExtension.class)
public class TestWelcomeView extends ApplicationTest{
    //Query string that contains the text on the label so we can find the label in the javaFX
    final String Label = "Welcome to Course List";

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
     * An assert test that verifies that a label exists on the scene with the correct query string and then tests the
     * text of the label to make sure it equals what it is supposed to say
     */
    @Test
    public void testWelcomeLabel(){
        verifyThat(Label, NodeMatchers.isNotNull());
        Label testLabel = find(Label);
        assertEquals("Welcome to Course List",testLabel.getText());
    }
}
