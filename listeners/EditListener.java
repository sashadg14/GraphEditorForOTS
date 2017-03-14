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
    public class EditListener implements MouseListener {
        TestFrame testFrame;
        Controller controller;
        public EditListener(TestFrame testFrame, Controller controller)
        {
            this.testFrame=testFrame;
            this.controller=controller;
        }



    public void mouseClicked(MouseEvent e) {
                if(e.getButton()==1)
                {
                    if(e.getClickCount()==2)
                        controller.addNode(e.getX(),e.getY());
                    controller.ifActivateNode(e.getX(),e.getY());
                }
                else
                {   JPopupMenu popup = new JPopupMenu();
                    JMenuItem setIdtfMenuItem = new JMenuItem("задать идентификатор");
                    setIdtfMenuItem.addActionListener( new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            controller.setIdtfForActiveNode(JOptionPane.showInputDialog ("Введите идентификатор"));
                            testFrame.renderAllElements();
                        }
                    });
                    popup.add(setIdtfMenuItem);
                    JMenuItem delNodeMenuItem = new JMenuItem("удалить узел");
                    popup.add(delNodeMenuItem);
                    delNodeMenuItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            controller.deleteActiveNode();
                            testFrame.renderAllElements();
                        }
                    });
                    popup.show(testFrame.getjLabel(), e.getX(), e.getY());
                }
                testFrame.renderAllElements();
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            {
                controller.ifActivateNode(mouseEvent.getX(),mouseEvent.getY());
                controller.setMovingNode(mouseEvent.getX(),mouseEvent.getY());
            }
            testFrame.renderAllElements();
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
                if(controller.isHaveMovingNode())
                    controller.deleteMovingNode();
            testFrame.renderAllElements();
        }
        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
