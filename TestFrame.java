package com.company;


import com.company.elementsOfGraph.Node;
import javafx.scene.paint.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.ArrayList;
/*
public class paint {
    public void bla() {
        BufferedImage image = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
        Graphics gr =image.getGraphics();
        //// рисуем!!
        // Ложим рисунок на JLabel, а ее - на JScrollPane
        JLabel jl = new JLabel(new ImageIcon(image));
        jl.addMouseListener(new CustomListener());
        JScrollPane jsp = new JScrollPane(jl);
        // создаем фрейм, ложим в центр созданный JScrollPane
        JFrame jf = new JFrame("JScroll Window");
        jf.setSize(800, 600);
        jf.add(jsp);

        gr.fillOval(10, 70, 70, 70);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public class CustomListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
         //   System.out.print("axdsadasdadsf");
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
}
*/

import javax.swing.JLabel;

public class TestFrame {
    BufferedImage imag;
    JLabel jl;
    ArrayList<Node> arrayOfNodes;
    public TestFrame() {
        JFrame frame= new JFrame("Test frame");
        arrayOfNodes=new ArrayList<Node>();
        imag = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
        jl = new JLabel(new ImageIcon(imag));
       // jl.setBounds(30,30,100,80);
        jl.setBackground(Color.white);
        jl.setOpaque(true);
        jl.addMouseListener(new CustomListener());
        JScrollPane jsp = new JScrollPane(jl);
        frame.setSize(1000, 800);
        jsp.setPreferredSize(new Dimension(1550, 0));
        jsp.setBounds(30,30,500,500);
        frame.add(jsp, BorderLayout.EAST);
        JMenuBar menuBar = new  JMenuBar();
        frame.setJMenuBar(menuBar);
      //  menuBar.setBounds(0,0,30,30);
        JMenu fileMenu = new  JMenu("Файл");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem(new AbstractAction("Загрузить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        }));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JToolBar toolbar = new  JToolBar("Toolbar", JToolBar.VERTICAL);

        JButton arrowButton = new  JButton(new  ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        arrowButton.addActionListener(new  ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            }
        });
        toolbar.add(arrowButton);
        JButton edgeButton = new  JButton(new  ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        edgeButton.addActionListener(new  ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            }
        });
        toolbar.add(edgeButton);
        toolbar.setBounds(50, 50, 300, 300);
        frame.add(toolbar);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              //  JFrame.setDefaultLookAndFeelDecorated(true);
                new TestFrame();
              //  frame.setPreferredSize(new Dimension(2000, 2000));
               // frame.pack();
               // frame.setLocationRelativeTo(null);
            }
        });
    }

    public class CustomListener implements MouseListener {

        Graphics g = imag.getGraphics();
        Graphics2D g2 = (Graphics2D)g;

        public void mouseClicked(MouseEvent e) {
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,1600,900);
            arrayOfNodes.add(new Node(e.getX()-15,e.getY()-15));
            for (Node node: arrayOfNodes)
                node.render(g2);
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

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

    }
}