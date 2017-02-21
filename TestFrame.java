package com.company;


import com.company.elementsOfGraph.Node;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JLabel;

public class TestFrame {
    BufferedImage imag;
    JLabel jl;
    ArrayList<Node> arrayOfNodes;
    Controller controller;

    public TestFrame() {
        controller = new Controller(this);
        JFrame frame = new JFrame("KBE: second edition");
        arrayOfNodes = new ArrayList<Node>();
        imag = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
        jl = new JLabel(new ImageIcon(imag));
        jl.addMouseListener(new CustomListener());
        jl.addMouseMotionListener(new MyMouseMotionListener());
        JScrollPane jsp = new JScrollPane(jl);
        frame.setSize(1000, 800);
        jsp.setPreferredSize(new Dimension(1550, 0));
        jsp.setBounds(30, 30, 500, 500);
        frame.add(jsp, BorderLayout.EAST);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem(new AbstractAction("Загрузить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        }));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JToolBar toolbar = new JToolBar("Toolbar", JToolBar.VERTICAL);

        final JButton arrowButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        arrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowActive.png"));
           //edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edgeActive.png"));
            }
        });
        toolbar.add(arrowButton);
        final JButton edgeButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        edgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
                edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edgeActive.png"));
            }
        });
        toolbar.add(edgeButton);
        frame.add(toolbar);
    }



    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestFrame();
            }
        });
    }

    public void setArrayOfNodes(ArrayList<Node> arrayOfNodes) {
        this.arrayOfNodes = arrayOfNodes;
    }

    private  void renderAllElements(Graphics2D graphics2D)
    {   graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,imag.getWidth(),imag.getHeight());
        for (Node node: arrayOfNodes){
            node.render(graphics2D);
        }
        jl.updateUI();
    }

    public class CustomListener implements MouseListener {
        Graphics2D g2 = (Graphics2D) imag.getGraphics();
        public void mouseClicked(MouseEvent e) {
        if(e.getButton()==1)
        {
            if(e.getClickCount()==2)
            controller.addNode(e.getX(),e.getY());
            controller.ifActivateNode(e.getX(),e.getY());
        }
            renderAllElements(g2);
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            controller.ifActivateNode(mouseEvent.getX(),mouseEvent.getY());
            controller.setMovingNode(mouseEvent.getX(),mouseEvent.getY());
            renderAllElements(g2);
            System.out.println("sdfdsafdsadafsf");
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

    public class MyMouseMotionListener implements MouseMotionListener
    { Graphics g = imag.getGraphics();
        Graphics2D g2 = (Graphics2D)g;

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            if(controller.isHaveMovingNode())
                controller.moveNode(mouseEvent.getX(),mouseEvent.getY());
            renderAllElements(g2);
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            controller.ifEnteredNode(mouseEvent.getX(),mouseEvent.getY());

            renderAllElements(g2);
        }
    }

}