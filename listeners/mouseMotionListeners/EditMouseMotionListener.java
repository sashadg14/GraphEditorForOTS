package com.company.listeners.mouseMotionListeners;

import com.company.Controllers.Controller;
import com.company.TestFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by alex on 14.03.2017.
 */
public class EditMouseMotionListener implements MouseMotionListener{

    TestFrame testFrame;
    Controller controller;
    public EditMouseMotionListener(TestFrame testFrame, Controller controller)
    {
        this.testFrame=testFrame;
        this.controller=controller;
    }
    @Override
public void mouseDragged(MouseEvent mouseEvent)
{
    {
        if (controller.isHaveMovingNode())
            controller.moveNode(mouseEvent.getX(), mouseEvent.getY());
        //  controller.ifEnterEdge(mouseEvent.getX(), mouseEvent.getY());
    }
    testFrame.renderAllElements();
}
    @Override
    public void mouseMoved(MouseEvent mouseEvent)
    {
        controller.ifEnteredNode(mouseEvent.getX(),mouseEvent.getY());
        controller.ifEnterEdge(mouseEvent.getX(), mouseEvent.getY());
        testFrame.renderAllElements();
    }
}
