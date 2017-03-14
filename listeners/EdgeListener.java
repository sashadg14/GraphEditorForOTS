package com.company.listeners;

import com.company.Controllers.Controller;
import com.company.TestFrame;
import com.company.elementsOfGraph.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by alex on 13.03.2017.
 */
public class EdgeListener implements MouseListener {
    TestFrame testFrame;
    Controller controller;
    public EdgeListener(TestFrame testFrame, Controller controller)
    {
        this.testFrame=testFrame;
        this.controller=controller;
    }
    public void mouseClicked(MouseEvent e) {

        {
            for(Node node:testFrame.getArrayOfNodes())
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
