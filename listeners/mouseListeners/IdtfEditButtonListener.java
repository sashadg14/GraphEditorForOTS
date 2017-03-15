package com.company.listeners.mouseListeners;

import com.company.Controllers.Controller;
import com.company.TestFrame;
import com.company.elementsOfGraph.Edge;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by alex on 15.03.2017.
 */
public class IdtfEditButtonListener implements MouseListener {
    TestFrame testFrame;
    Controller controller;
    public IdtfEditButtonListener(TestFrame testFrame, Controller controller)
    {
        this.testFrame=testFrame;
        this.controller=controller;
    }

    public void mouseClicked(MouseEvent e) {
           if(e.getButton()==1)
        {   controller.ifActivateNode(e.getX(),e.getY());
            if(controller.haveActiveNode())
            controller.setIdtfForActiveNode(JOptionPane.showInputDialog ("Введите идентификатор"));
            if(controller.haveActiveEdge())
            controller.setWeigth(JOptionPane.showInputDialog ("Введите вес для дуги"));
            testFrame.renderAllElements();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

