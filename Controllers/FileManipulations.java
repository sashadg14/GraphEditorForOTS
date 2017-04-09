package com.company.Controllers;

import com.company.elementsOfGraph.Edge;
import com.company.elementsOfGraph.Graph;
import com.company.elementsOfGraph.Node;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 12.03.2017.
 */
public class FileManipulations {
    private Controller controller;

    FileManipulations(Controller controller) {
        this.controller = controller;
    }

    void SaveGraph(Graph graph) {
        String fileName ="";
        JFileChooser jf = new JFileChooser();
        int result = jf.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileName = jf.getSelectedFile().getAbsolutePath();
        }
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("<GRAPH>\n");
            saveNodes(fileWriter, graph.getNodeList());
            saveEdges(fileWriter, graph.getEdgeList());
            fileWriter.write("</GRAPH>");
            fileWriter.close();
        } catch (IOException e) {
            JOptionPane.showInputDialog("песец файлику");
        }


    }

    private void saveNodes(FileWriter fileWriter, List<Node> nodeArrayList) {
        try {
            fileWriter.write("<Nodes>\n");
            for (Node node : nodeArrayList) {
                fileWriter.write("<node type=\"node/constant\" idtf=\"" + node.getIdentificator() + "\"" + " id=\"" + node.getId() + "\"" + " x=\"" + node.getCenterX() + "\" y=\"" + node.getCenterY() + "\">");
                fileWriter.write("\n</node>\n");
            }
            fileWriter.write("</Nodes>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveEdges(FileWriter fileWriter, List<Edge> edgeArrayList) {
        try {
            fileWriter.write("<Edges>\n");
            for (Edge edge : edgeArrayList) {
                fileWriter.write("<edge type=\"edge/constant\" " + "id_begin=\"" + edge.getFirstNode().getId() + "\" " + "id_end=\"" + edge.getSecondNode().getId() + "\">");
                fileWriter.write("\n</edge>\n");
            }
            fileWriter.write("</Edges>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadGraph(Graph graph) {
        String fileName = null;
        JFileChooser jf = new JFileChooser();
        int result = jf.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileName = jf.getSelectedFile().getAbsolutePath();
        }
        FileReader reader = null;
        try {reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int c;
        String str="";
        try {
            while ((c = reader.read()) != -1) {

                str+=(char)c;
            }
            String[] mas=str.split("\\n*.*<\\/*GRAPH>|.*\\n*.*<\\/*Nodes>*|\\n*.*<node\\s*>*|\\n*.*<\\/node>.*|\\n*<Edges>(.*\\n*)*<\\/Edges>\\n*.*");
            for(int i=0;i<mas.length;i++)
            {String[] masOfPiese;
                if(mas[i].length()!=0)
                {
                    masOfPiese=mas[i].split(".*type=\"|\"\\sidtf=\"|\" id=\"|\" x=\"|\" y=\"|\">");
                    graph.addNode(new Node(masOfPiese[2].toString(),Integer.parseInt( masOfPiese[3]),Integer.parseInt( masOfPiese[4]),Integer.parseInt( masOfPiese[5])));
                }
            }
            mas=null;
            mas=str.split("(\\n*.*<\\/*GRAPH>)\\n*|(<Nodes>(\\n.*\\n*)*<\\/Nodes>)|\\n*.*(<\\/*Edges>).*\\n*|<edge |\\n*<\\/edge>.*\\n*");
            for(int i=0;i<mas.length;i++)
            {String[] masOfPiese;
                if(mas[i].length()!=0)
                {
                    masOfPiese=mas[i].split(".*type=\"|\"\\s|id_begin=\"|id_end=\"|\">");
                    graph.createEdgeBehindTwoNodeWithId(Integer.parseInt(masOfPiese[3]),Integer.parseInt(masOfPiese[5]));
                     }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
