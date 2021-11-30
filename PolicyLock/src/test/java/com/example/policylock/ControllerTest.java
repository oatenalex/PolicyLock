package com.example.policylock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Controller controller = new Controller();

    @Test
    void getOSType(){
        String OS = controller.getOsType();
        boolean validOS = OS.equals("windows") || OS.equals("mac") || OS.equals("linux")|| OS.equals("other");
        assertTrue(validOS);
    }
    @Test
    void checkOS(){
        controller.getOsType();
        String OS = controller.getOsType(); //Checks if not null
        boolean validOS = OS.equals("windows") || OS.equals("mac") || OS.equals("linux")|| OS.equals("other");
        assertTrue(validOS);
    }
}