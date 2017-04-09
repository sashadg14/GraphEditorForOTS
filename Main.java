package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.Properties;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class Main{
    public  static void main(String args[])
    {        final TestFrame testFrame = new TestFrame();
        Timer timer= new Timer( 30 , new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                testFrame.rend();
            }
        });
        timer.start();
    }
}

