package com.company;


import com.company.Controllers.Controller;
import com.company.elementsOfGraph.Edge;
import com.company.elementsOfGraph.Node;
import com.company.Controllers.FileManipulations;

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
    ArrayList<Edge> arrayOfEdges;
    Controller controller;
    int mode=1;
    FileManipulations fileManipulations;

    public TestFrame() {
        fileManipulations =new FileManipulations();
        controller = new Controller(this);
        JFrame frame = new JFrame("KBE: second edition");
        arrayOfNodes = new ArrayList<Node>();
        arrayOfEdges = new ArrayList<Edge>();
        imag = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
        jl = new JLabel(new ImageIcon(imag));
        jl.addMouseListener(new CustomListener());
        jl.addMouseMotionListener(new MyMouseMotionListener());
        JScrollPane jsp = new JScrollPane(jl);
        frame.setSize(1000, 800);
        jsp.setPreferredSize(new Dimension(1550, 0));
       // jsp.setBounds(30, 30, 500, 500);
        frame.add(jsp, BorderLayout.EAST);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem(new AbstractAction("Сохранить как...") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        fileManipulations.SaveGraph(arrayOfNodes,arrayOfEdges);
            }
        }));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JToolBar toolbar = new JToolBar("Toolbar", JToolBar.VERTICAL);

        final JButton arrowButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        arrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowActive.png"));
       //    edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edgeActive.png"));
                mode=1;
            }
        });
        toolbar.add(arrowButton);
        final JButton edgeButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        edgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
                //edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edgeActive.png"));
                mode=2;
            }
        });
        toolbar.add(edgeButton);
        frame.add(toolbar);
    }



    public static void main(String[] args) {
        /*javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            }
        });*/
        new TestFrame();
    }

    public void setArrayOfNodes(ArrayList<Node> arrayOfNodes) {
        this.arrayOfNodes = arrayOfNodes;
    }
    public void setArrayOfEdges(ArrayList<Edge> arrayOfEdges) {
        this.arrayOfEdges = arrayOfEdges;
    }

    private  void renderAllElements(Graphics2D graphics2D)
    {   graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,imag.getWidth(),imag.getHeight());

        for (Edge edge:arrayOfEdges)
        {
            edge.render(graphics2D);
        }

        for (Node node: arrayOfNodes){
            node.render(graphics2D);
        }
        jl.updateUI();
    }

    public class CustomListener implements MouseListener {
        Graphics2D g2 = (Graphics2D) imag.getGraphics();
        public void mouseClicked(MouseEvent e) {
            if (mode==1)
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
                    }
                });
                popup.add(setIdtfMenuItem);
                JMenuItem delNodeMenuItem = new JMenuItem("удалить узел");
                popup.add(delNodeMenuItem);
                delNodeMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        controller.deleteActiveNode();
                    }
                });
                popup.show(jl, e.getX(), e.getY());
            }
            if(mode==2)
            {
                for(Node node:arrayOfNodes)
                {
                    if(node.isEntered())
                        controller.addNodeForConnection(node);
                }
            }
            renderAllElements(g2);
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            if(mode==1)
            {
            controller.ifActivateNode(mouseEvent.getX(),mouseEvent.getY());
            controller.setMovingNode(mouseEvent.getX(),mouseEvent.getY());
            renderAllElements(g2);
            }
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
                if (mode==1)
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
    {   Graphics2D g2 = (Graphics2D)imag.getGraphics();

        @Override
        public void mouseDragged(MouseEvent mouseEvent)
        {
            if(mode==1)
            if(controller.isHaveMovingNode())
                controller.moveNode(mouseEvent.getX(),mouseEvent.getY());
            renderAllElements(g2);
        }
        @Override
        public void mouseMoved(MouseEvent mouseEvent)
        {
            controller.ifEnteredNode(mouseEvent.getX(),mouseEvent.getY());
            renderAllElements(g2);
        }
    }

}