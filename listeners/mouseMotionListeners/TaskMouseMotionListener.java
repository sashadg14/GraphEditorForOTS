package com.company.listeners.mouseMotionListeners;

import com.company.Controllers.Controller;
import com.company.TestFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by alex o n 16.03.2017.
 */
public class TaskMouseMotionListener implements MouseMotionListener {

    private TestFrame testFrame;
    private Controller controller;
    public TaskMouseMotionListener(TestFrame testFrame, Controller controller)
    {
        this.testFrame=testFrame;
        this.controller=controller;
    }
    @Override
    public void mouseDragged(MouseEvent mouseEvent)
    {

    }
    @Override
    public void mouseMoved(MouseEvent mouseEvent)
    {
        controller.ifEnteredNode(mouseEvent.getX(),mouseEvent.getY());
        testFrame.renderAllElements();
    }
}
