package com.company;

import com.company.elementsOfGraph.Node;

import java.util.ArrayList;

/**
 * Created by alex on 21.02.2017.
 */
public class Controller
{  private TestFrame testFrame;
    private ArrayList<Node> arrayOfNodes;
    private Node isMovingNode;
    private boolean isHaveMovingNode=false;
    Controller(TestFrame testFrame)
    {   isMovingNode=null;
        this.testFrame=testFrame;
        arrayOfNodes=new ArrayList<Node>();
    }

    public void addNode(int nodeX, int nodeY)
    {
        arrayOfNodes.add(new Node(nodeX,nodeY));
        testFrame.setArrayOfNodes(arrayOfNodes);
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

    public void setMovingNode(int posX, int posY)
    {
        for(Node node: arrayOfNodes)
        {
            if(node.isOverlapWithCursor(posX,posY))
            {System.out.println("set");
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
    {           System.out.println("move");

    for (Node node: arrayOfNodes)
    {       if (node==isMovingNode)
            {
            node.setCenterX(posX);
            node.setCenterY(posY);
            }
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
