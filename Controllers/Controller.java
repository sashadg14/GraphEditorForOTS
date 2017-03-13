package com.company.Controllers;

import com.company.TestFrame;
import com.company.elementsOfGraph.Edge;
import com.company.elementsOfGraph.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by alex on 21.02.2017.
 */
public class Controller
{  private TestFrame testFrame;
    private ArrayList<Node> arrayOfNodes;
    private ArrayList<Edge> arrayOfEdges;
    private Node isMovingNode;
    private boolean isHaveMovingNode=false;
    private Node[] masOfConnectingNodes;
    private int countOfConectingNodes=0;

    public Controller(TestFrame testFrame)
    {   isMovingNode=null;
        this.testFrame=testFrame;
        arrayOfNodes=new ArrayList<Node>();
        arrayOfEdges=new ArrayList<Edge>();
        masOfConnectingNodes=new Node[2];
    }

    public void addNode(int nodeX, int nodeY)
    {
        arrayOfNodes.add(new Node(nodeX-15,nodeY-15));
        testFrame.setArrayOfNodes(arrayOfNodes);
    }
    private void addEdge(Node node1, Node node2)
    {
        arrayOfEdges.add(new Edge(node1,node2));
        testFrame.setArrayOfEdges(arrayOfEdges);
        testFrame.setArrayOfEdges(arrayOfEdges);
    }

    public void ifActivateNode(int posX, int posY)
    {
        for(Node node: arrayOfNodes)
        {
            if(node.isOverlapWithCursor(posX,posY))
            node.setActive(true);
            else node.setActive(false);
        }

    }
    public void setIdtfForActiveNode(String idtf)
    {
        for(Node node: arrayOfNodes)
        {   if(node.isActive())
            node.setIdentificator(idtf);
        }

    }
    public void deleteActiveNode()
    {
        Iterator<Node> nodeIterator=arrayOfNodes.iterator();
        while (nodeIterator.hasNext())
        {   Node node = nodeIterator.next();
            if(node.isActive()) {
            Iterator<Edge> edgeIterator=arrayOfEdges.iterator();
            while (edgeIterator.hasNext())
            {Edge edge=edgeIterator.next();
                if( (node==edge.getFirstNode())||node==edge.getSecondNode())  {
                    edgeIterator.remove();
                }
            }
            nodeIterator.remove();
        }
        }
        testFrame.setArrayOfEdges(arrayOfEdges);
        testFrame.setArrayOfNodes(arrayOfNodes);

    }

    public void setMovingNode(int posX, int posY)
    {
        for(Node node: arrayOfNodes)
        {
            if(node.isOverlapWithCursor(posX,posY))
            {
             isMovingNode=node;
             isHaveMovingNode=true;
            }
        }
    }

    public void deleteMovingNode()
    {
        isMovingNode=null;
        isHaveMovingNode=false;
    }

    public void moveNode(int posX, int posY)
    {

    for (Node node: arrayOfNodes)
    {
        if (node==isMovingNode)
            {
            node.setCenterX(posX);
            node.setCenterY(posY);
            }
    }
    }

    public void addNodeForConnection(Node node)
    {   System.out.println("sddsfaads");
        masOfConnectingNodes[countOfConectingNodes]=node;
        countOfConectingNodes++;
        if(countOfConectingNodes==2)
        {
            countOfConectingNodes=0;
            addEdge(masOfConnectingNodes[0],masOfConnectingNodes[1]);
            masOfConnectingNodes[0]=null;
            masOfConnectingNodes[1]=null;
        }
    }

    public boolean isHaveMovingNode() {
        return isHaveMovingNode;
    }

    public void ifEnteredNode(int posX, int posY)
    {
        for (Node node: arrayOfNodes){
            if((node.isOverlapWithCursor(posX,posY))&&(node.isActive()!=true))
                node.setEntered(true);
            else
            if(!node.isActive())
                node.setEntered(false);
        }
    }

}
