package com.example.policylock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Controller controller = new Controller();

    @Test
    void login() {
    }

    @Test
    void logout() {
    }

    @Test
    void getOSType(){
        String OS = controller.getOSType();
        boolean validOS = OS.equals("windows") || OS.equals("mac") || OS.equals("linux")|| OS.equals("other");
        assertTrue(validOS);
    }
    @Test
    void checkOS(){
        controller.getOSType();
        String OS = controller.getOSType(); //Checks if not null
        boolean validOS = OS.equals("windows") || OS.equals("mac") || OS.equals("linux")|| OS.equals("other");
        assertTrue(validOS);
    }
}