package com.company.Controllers;

import com.company.elementsOfGraph.Edge;
import com.company.elementsOfGraph.Node;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alex on 12.03.2017.
 */
public class FileManipulations
{
    public FileManipulations()
    {

    }

    public void SaveGraph(ArrayList<Node> nodeArrayList, ArrayList<Edge> edgeArrayList)
    {
        String fileName = null;
        JFileChooser jf= new  JFileChooser();
        int  result = jf.showSaveDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            fileName = jf.getSelectedFile().getAbsolutePath();
        }
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("<GRAPH:"+fileName+">\n");
            saveNodes(fileWriter,nodeArrayList);
            saveEdges(fileWriter,edgeArrayList);
            fileWriter.write("</GRAPH>");
            fileWriter.close();
        } catch (IOException e) {
            JOptionPane.showInputDialog ("песец файлику");
        }


    }
    private void saveNodes(FileWriter fileWriter, ArrayList<Node> nodeArrayList)
    {
        try {
            fileWriter.write("<Node sector>\n");
            for (Node node: nodeArrayList)
            {
                fileWriter.write("<node type=\"node/constant\" idtf=\""+node.getIdentificator()+"\"" +" id=\""+node.getId()+"\"" +" x="+node.getCenterX()+" y=\""+node.getCenterY()+"\">");
                fileWriter.write("\n</node\n");
            }
            fileWriter.write("</Node sector>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveEdges(FileWriter fileWriter, ArrayList<Edge> edgeArrayList)
    {
        try {
            fileWriter.write("<Edge sector>\n");
            for (Edge edge: edgeArrayList)
            {
                fileWriter.write("<edge type=\"edge/constant\" "+"id_begin=\""+edge.getFirstNode().getId()+"\" "+"id_end=\""+edge.getSecondNode().getId()+"\">");
                fileWriter.write("\n</edge\n");
            }
            fileWriter.write("</Edge sector>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
