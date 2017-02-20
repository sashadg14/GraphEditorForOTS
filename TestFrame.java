package com.company;


import com.company.elementsOfGraph.Node;

import javax.swing.*;
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
        Frame frame= new Frame("Test frame");
        arrayOfNodes=new ArrayList<Node>();
        imag = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
        //// рисуем!!
        imag.setRGB(255,25,200);
        // Ложим рисунок на JLabel, а ее - на JScrollPane
        jl = new JLabel(new ImageIcon(imag));
        jl.addMouseListener(new CustomListener());
        JScrollPane jsp = new JScrollPane(jl);
        // создаем фрейм, ложим в центр созданный JScrollPane
   //     JFrame jf = new JFrame("JScroll Window");
        frame.setSize(800, 600);
        frame.add(jsp);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              //  JFrame.setDefaultLookAndFeelDecorated(true);
                TestFrame frame = new TestFrame();
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