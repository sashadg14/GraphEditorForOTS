package com.company;


import com.company.Controllers.Controller;
import com.company.Controllers.CreatingMatrix;
import com.company.elementsOfGraph.Graph;
import com.company.listeners.mouseListeners.*;
import com.company.listeners.mouseMotionListeners.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TestFrame {
    BufferedImage[] imag;
    JLabel[] jLabel;
    Graph[] graph;
    JScrollPane[] jsp;
    JTabbedPane jTabbedPane;
    Controller controller;
    EditListener editListener;
    EdgeListener edgeListener;
    DeleteButtonListener deleteButtonListener;
    IdtfEditButtonListener idtfEditButtonListener;

    EditMouseMotionListener editMouseMotionListener;
    EdgeMouseMotionListener edgeMouseMotionListener;
    DeleteButtonMouseMotionListener deleteButtonMouseMotionListener;
    IdtfEditButtonMouseMotionListeners idtfEditButtonMouseMotionListeners;

    int noOfTab=0;

    Graphics2D[] graphics2D;
    JToolBar toolbar;
    final JButton arrowButton ;
    final JButton edgeButton;
    final JButton deleteButton;
    final JButton editItdfButton;
    final JButton taskButton;
    JFrame frame;
    public TestFrame() {
        graph=new Graph[10];
        jLabel=new JLabel[10];
        imag= new BufferedImage[10];
        jsp = new JScrollPane[10];
        graphics2D=new Graphics2D[10];
        for (int i=0;i<10;i++) {
            graph[i] = new Graph(this);
            imag[i] = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
            jLabel[i] = new JLabel(new ImageIcon(imag[i]));
            graphics2D[i]=(Graphics2D)imag[i].getGraphics();
            //jsp[i].setPreferredSize(new Dimension(1550, 800));
        }
        controller = new Controller(this);
        frame = new JFrame("KBE: second edition");
        frame.setSize(1000, 800);
        try
        {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        arrowButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton= new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        // imag = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
        //jLabel = new JLabel(new ImageIcon(imag));
        editListener=new EditListener(this,controller);
        edgeListener=new EdgeListener(this,controller);
        deleteButtonListener=new DeleteButtonListener(this,controller);
        idtfEditButtonListener=new IdtfEditButtonListener(this,controller);

        editMouseMotionListener=new EditMouseMotionListener(this,controller);
        edgeMouseMotionListener=new EdgeMouseMotionListener(this,controller);
        deleteButtonMouseMotionListener=new DeleteButtonMouseMotionListener(this,controller);
        idtfEditButtonMouseMotionListeners=new IdtfEditButtonMouseMotionListeners(this,controller);

        creatingTolbar();
        //   creatingTolbar2();
        // jsp.setCom
        jsp[noOfTab]= new JScrollPane(jLabel[noOfTab]);
        jsp[noOfTab].setPreferredSize(new Dimension(1550, 800));
        // jsp.setBounds(30, 30, 500, 500);
        // JTabbedPane jTabbedPane = new JTabbedPane()
       jTabbedPane = new JTabbedPane();

        frame.add(jTabbedPane, BorderLayout.EAST);
        //frame.add(jsp, BorderLayout.EAST);
        jTabbedPane.addTab("Graph"+(noOfTab+1),jsp[0]);
        jTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                System.out.println(jTabbedPane.getSelectedIndex());
                deleteAllListeners();
                noOfTab=jTabbedPane.getSelectedIndex();
              //  graphics2D[noOfTab]=(Graphics2D)imag[noOfTab].getGraphics();
            }
        });
        jTabbedPane.getSelectedIndex();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        creatingFileMenu();


        //System.out.println("-----------"+mas[i]);

       // String[] mas1=mas[0].split()

    }

    private void addListnersForEditGraph()
    {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        jLabel[noOfTab].removeMouseListener(edgeListener);
        jLabel[noOfTab].removeMouseMotionListener(edgeMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(deleteButtonListener);
        jLabel[noOfTab].removeMouseMotionListener(deleteButtonMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(idtfEditButtonListener);
        jLabel[noOfTab].removeMouseMotionListener(idtfEditButtonMouseMotionListeners);
        jLabel[noOfTab].addMouseListener(editListener);
        jLabel[noOfTab].addMouseMotionListener(editMouseMotionListener);
    }
    private void deleteAllListeners()
    {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        jLabel[noOfTab].removeMouseListener(edgeListener);
        jLabel[noOfTab].removeMouseMotionListener(edgeMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(deleteButtonListener);
        jLabel[noOfTab].removeMouseMotionListener(deleteButtonMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(idtfEditButtonListener);
        jLabel[noOfTab].removeMouseMotionListener(idtfEditButtonMouseMotionListeners);
        jLabel[noOfTab].removeMouseListener(editListener);
        jLabel[noOfTab].removeMouseMotionListener(editMouseMotionListener);
    }

    public void addListenersForAddingEdges()
    {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edgeActive.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        jLabel[noOfTab].removeMouseListener(editListener);
        jLabel[noOfTab].removeMouseMotionListener(editMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(deleteButtonListener);
        jLabel[noOfTab].removeMouseMotionListener(deleteButtonMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(idtfEditButtonListener);
        jLabel[noOfTab].removeMouseMotionListener(idtfEditButtonMouseMotionListeners);

        jLabel[noOfTab].addMouseListener(edgeListener);
        jLabel[noOfTab].addMouseMotionListener(edgeMouseMotionListener);
    }

    public void addListnersForDeletingElements()
    {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\deleteActive.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        jLabel[noOfTab].removeMouseListener(editListener);
        jLabel[noOfTab].removeMouseMotionListener(editMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(edgeListener);
        jLabel[noOfTab].removeMouseMotionListener(edgeMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(idtfEditButtonListener);
        jLabel[noOfTab].removeMouseMotionListener(idtfEditButtonMouseMotionListeners);

        jLabel[noOfTab].addMouseListener(deleteButtonListener);
        jLabel[noOfTab].addMouseMotionListener(deleteButtonMouseMotionListener);
    }

    public void addListenersForEditingValues()
    {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEditActive.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        jLabel[noOfTab].removeMouseListener(editListener);
        jLabel[noOfTab].removeMouseMotionListener(editMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(edgeListener);
        jLabel[noOfTab].removeMouseMotionListener(edgeMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(deleteButtonListener);
        jLabel[noOfTab].removeMouseMotionListener(deleteButtonMouseMotionListener);

        jLabel[noOfTab].addMouseListener(idtfEditButtonListener);
        jLabel[noOfTab].addMouseMotionListener(idtfEditButtonMouseMotionListeners);
    }

    public void addListenersForTaskRealization()
    {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButtonActive.png"));

        jLabel[noOfTab].removeMouseListener(editListener);
        jLabel[noOfTab].removeMouseMotionListener(editMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(edgeListener);
        jLabel[noOfTab].removeMouseMotionListener(edgeMouseMotionListener);
        jLabel[noOfTab].removeMouseListener(deleteButtonListener);
        jLabel[noOfTab].removeMouseMotionListener(deleteButtonMouseMotionListener);

        jLabel[noOfTab].addMouseListener(new TaskMouseListener(this,controller));
        jLabel[noOfTab].addMouseMotionListener(new TaskMouseMotionListener(this,controller));
    }

    private void creatingFileMenu()
    {
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem(new AbstractAction("Новый граф") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jsp[noOfTab+1]= new JScrollPane(jLabel[noOfTab+1]);
                jsp[noOfTab+1].setPreferredSize(new Dimension(1550, 800));
                jTabbedPane.addTab("Graph"+(noOfTab+1),jsp[noOfTab+1]);
                noOfTab=noOfTab+1;
            }
        }));

        fileMenu.add(new JMenuItem(new AbstractAction("Сохранить как...") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.SaveGraphInFile();
            }
        }));
        fileMenu.add(new JMenuItem(new AbstractAction("Загрузить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.loadGraphFromFile();
            }
        }));
        fileMenu.add(new JMenuItem(new AbstractAction("выполнить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                controller.doTask();
            }
        }));
        JMenu graphMenu = new JMenu("Граф");
        menuBar.add(graphMenu);
        graphMenu.add(new JMenuItem(new AbstractAction("Редактирование") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addListnersForEditGraph();
            }
        }));
        graphMenu.add(new JMenuItem(new AbstractAction("Добавить дугу") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addListenersForAddingEdges();
            }
        }));
        graphMenu.add(new JMenuItem(new AbstractAction("Удаление элемента") {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            addListnersForDeletingElements();
        }
    }));
        graphMenu.add(new JMenuItem(new AbstractAction("Задать значение") {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                addListenersForEditingValues();
            }
        }));
        graphMenu.add(new JMenuItem(new AbstractAction("Количество дуг") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(frame, "Количество дуг: "+graph[noOfTab].getEdgeList().toArray().length);
            }
        }));
        graphMenu.add(new JMenuItem(new AbstractAction("Количество вершин") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(frame, "Количество вершин: "+graph[noOfTab].getNodeList().toArray().length);
            }
        }));
    }
    private void creatingTolbar()
    {
        toolbar = new JToolBar("Toolbar", JToolBar.VERTICAL);

        arrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            addListnersForEditGraph();

            }
        });
        toolbar.add(arrowButton);
        edgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            addListenersForAddingEdges();
            }
        });
        toolbar.add(edgeButton);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                addListnersForDeletingElements();
            }
        });
        toolbar.add(deleteButton);
        editItdfButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            addListenersForEditingValues();
            }
        });
        toolbar.add(editItdfButton);
        taskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CreatingMatrix creatingMatrix = new CreatingMatrix(getGraph());
                creatingMatrix.createMatr();
            }
        });
        toolbar.add(taskButton);
        toolbar.setOrientation(1);
        frame.add(toolbar);
    }
    private void creatingTolbar2()
    {
      JToolBar  toolbar = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
        //toolbar.add(arrowButton);
        toolbar.add(taskButton);
     //   toolbar.setOrientation(0);
        frame.add(toolbar, BorderLayout.NORTH);
    }

    public JLabel getjLabel() {
        return jLabel[noOfTab];
    }

    public void renderAllElements()
    {
        graph[noOfTab].renderAllElements();
    }

    public void rend(){graph[noOfTab].renderAllElements_part2();}


    public void setGraph(Graph graph) {
        this.graph[noOfTab] = graph;
    }

    public Graph getGraph() {
        return graph[noOfTab];
    }

    public BufferedImage getImag() {
        return imag[noOfTab];
    }

    public Graphics2D getGraphics2D() {
        return graphics2D[noOfTab];
    }
}