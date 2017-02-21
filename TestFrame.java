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
    public TestFrame() {
        JFrame frame = new JFrame("KBE: second edition");
        arrayOfNodes = new ArrayList<Node>();
        imag = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
        jl = new JLabel(new ImageIcon(imag));
        // jl.setBounds(30,30,100,80);
        jl.setBackground(Color.white);
        jl.setOpaque(true);
        jl.addMouseListener(new CustomListener());
        jl.addMouseMotionListener(new MyMouseMotionListener());
        JScrollPane jsp = new JScrollPane(jl);
        frame.setSize(1000, 800);
        jsp.setPreferredSize(new Dimension(1550, 0));
        jsp.setBounds(30, 30, 500, 500);
        frame.add(jsp, BorderLayout.EAST);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        //  menuBar.setBounds(0,0,30,30);
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



    public class CustomListener implements MouseListener {

        Graphics g = imag.getGraphics();
        Graphics2D g2 = (Graphics2D)g;

        public void mouseClicked(MouseEvent e) {
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,1600,900);
            if(e.getClickCount()==2)
            arrayOfNodes.add(new Node(e.getX()-15,e.getY()-15));
            for (Node node: arrayOfNodes){
                if(node.isOverlapWithCursor(e.getX(),e.getY()))
                    node.setActive(true);
               else
                    node.setActive(false);
                node.render(g2);
            }
            g.setColor(Color.red);
            g.fillPolygon(new int [] {0, 0, 50}, new int [] {0, 50, 0}, 3);
            jl.updateUI();


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

    public class MyMouseMotionListener implements MouseMotionListener
    { Graphics g = imag.getGraphics();
        Graphics2D g2 = (Graphics2D)g;

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            for (Node node: arrayOfNodes){
                if((node.isOverlapWithCursor(mouseEvent.getX(),mouseEvent.getY()))&&(node.isActive()!=true))
                    node.setEntered(true);
                else
                    if(!node.isActive())
                    node.setEntered(false);
                node.render(g2);
            }
            jl.updateUI();
        }
    }

}