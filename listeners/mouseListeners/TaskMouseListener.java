package com.company.listeners.mouseListeners;

import com.company.Controllers.Controller;
import com.company.TestFrame;
import com.company.elementsOfGraph.Node;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by alex o n 16.03.2017.
 */
public class TaskMouseListener implements MouseListener {
    TestFrame testFrame;
    Controller controller;
    public TaskMouseListener(TestFrame testFrame, Controller controller)
    {
        this.testFrame=testFrame;
        this.controller=controller;
    }
    public void mouseClicked(MouseEvent e) {
        {
            for(Node node:testFrame.getGraph().getNodeList())
            {
                if(node.isEntered())
                    controller.addNodeForConnection(node);
            }
        }
        testFrame.renderAllElements();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(controller.isHaveMovingNode())
            controller.deleteMovingNode();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

