package com.company;


import com.company.Controllers.Controller;
import com.company.elementsOfGraph.Edge;
import com.company.elementsOfGraph.Node;
import com.company.Controllers.FileManipulations;
import com.company.listeners.EdgeListener;
import com.company.listeners.EditListener;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TestFrame {
    BufferedImage imag;
    JLabel jLabel;
    ArrayList<Node> arrayOfNodes;
    ArrayList<Edge> arrayOfEdges;
    Controller controller;
    int mode=1;
    FileManipulations fileManipulations;
    MouseListener mouseListener;
    EditListener editListener;
    EdgeListener edgeListener;
    Graphics2D graphics2D;
    JToolBar toolbar;
    JFrame frame;
    public TestFrame() {
        fileManipulations =new FileManipulations();
        controller = new Controller(this);
        frame = new JFrame("KBE: second edition");
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        arrayOfNodes = new ArrayList<Node>();
        arrayOfEdges = new ArrayList<Edge>();
        imag = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
        jLabel = new JLabel(new ImageIcon(imag));
        graphics2D=(Graphics2D)imag.getGraphics();
        mouseListener=null;
        editListener=new EditListener(this,controller);
        edgeListener=new EdgeListener(this,controller);
        jLabel.addMouseListener(mouseListener);
        jLabel.addMouseMotionListener(new MyMouseMotionListener());
        JScrollPane jsp = new JScrollPane(jLabel);
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
        creatingTolbar();

    }
    private void creatingTolbar()
    {
        toolbar = new JToolBar("Toolbar", JToolBar.VERTICAL);

        final JButton arrowButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        final JButton edgeButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        arrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowActive.png"));
                edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
                mode=1;
                jLabel.removeMouseListener(edgeListener);
                jLabel.addMouseListener(editListener);
            }
        });
        toolbar.add(arrowButton);
        edgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
                edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edgeActive.png"));
                mode=2;
                jLabel.removeMouseListener(editListener);
                jLabel.addMouseListener(edgeListener);
            }
        });
        toolbar.add(edgeButton);
        frame.add(toolbar);
    }
    public JLabel getjLabel() {
        return jLabel;
    }
    public void setArrayOfNodes(ArrayList<Node> arrayOfNodes) {
        this.arrayOfNodes = arrayOfNodes;
    }
    public void setArrayOfEdges(ArrayList<Edge> arrayOfEdges) {
        this.arrayOfEdges = arrayOfEdges;
    }

    public   void renderAllElements()
    {   graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,imag.getWidth(),imag.getHeight());

        for (Edge edge:arrayOfEdges)
        {
            edge.render(graphics2D);
        }

        for (Node node: arrayOfNodes){
            node.render(graphics2D);
        }
        jLabel.updateUI();
    }

    public ArrayList<Node> getArrayOfNodes() {
        return arrayOfNodes;
    }

    public ArrayList<Edge> getArrayOfEdges() {
        return arrayOfEdges;
    }

    public class MyMouseMotionListener implements MouseMotionListener
    {   @Override
        public void mouseDragged(MouseEvent mouseEvent)
        {
            if(mode==1)
            {
                if (controller.isHaveMovingNode())
                    controller.moveNode(mouseEvent.getX(), mouseEvent.getY());
              //  controller.ifEnterEdge(mouseEvent.getX(), mouseEvent.getY());
            }
            renderAllElements();
        }
        @Override
        public void mouseMoved(MouseEvent mouseEvent)
        {
            controller.ifEnteredNode(mouseEvent.getX(),mouseEvent.getY());
            controller.ifEnterEdge(mouseEvent.getX(), mouseEvent.getY());
            renderAllElements();
        }
    }

}