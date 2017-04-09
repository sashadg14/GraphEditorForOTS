package com.company.elementsOfGraph;

import com.company.TestFrame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alex on 14.03.2017.
 */
public class Graph {
    private List<Node> nodeList = new ArrayList<Node>();
    private List<Edge> edgeList = new ArrayList<Edge>();
    private TestFrame testFrame;
    public Graph(TestFrame testFrame)
    {
        this.testFrame=testFrame;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void addEdge(Edge edge)
    {
        edgeList.add(edge);
    }

    public void addNode(Node node)
    {
        nodeList.add(node);
    }
    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }
    public void renderAllElements()
    {
      /*  testFrame.getGraphics2D().setColor(Color.WHITE);
        testFrame.getGraphics2D().fillRect(0,0,testFrame.getImag().getWidth(),testFrame.getImag().getHeight());
        for (Edge edge:edgeList)
        {
            edge.render(testFrame.getGraphics2D());
        }

        for (Node node: nodeList){
            node.render(testFrame.getGraphics2D());
        }
        testFrame.getjLabel().updateUI();*/

    }

    public void renderAllElements_part2()
    {
        testFrame.getGraphics2D().setColor(Color.WHITE);
        testFrame.getGraphics2D().fillRect(0,0,testFrame.getImag().getWidth(),testFrame.getImag().getHeight());
        for (Edge edge:edgeList)
        {
            edge.render(testFrame.getGraphics2D());
        }

        for (Node node: nodeList){
            node.render(testFrame.getGraphics2D());
        }
        testFrame.getjLabel().updateUI();

    }

    public void createEdgeBehindTwoNodeWithId(long idBeginNode, long idEndNode)
    {
        Node nodeBegin=null;
        Node nodeEnd = null;
        for (Node node: nodeList)
        {
         if(node.getId()==idBeginNode)
             nodeBegin=node;
         else if(node.getId()==idEndNode)
             nodeEnd=node;
        }
        addEdge(new Edge(nodeBegin,nodeEnd));
    }

    public void deleteOllElements()
    { Iterator<Node> nodeIterator=nodeList.iterator();
        while (nodeIterator.hasNext())
        {   nodeIterator.next();
            nodeIterator.remove();}
    Iterator<Edge> edgeIterator=edgeList.iterator();
    while (edgeIterator.hasNext())
    { edgeIterator.next();
        edgeIterator.remove();
    }
    }
}
