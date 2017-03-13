package com.company.elementsOfGraph;

import javafx.geometry.Rectangle2D;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alex on 19.02.2017.
 */
public class Edge extends ArrayList {
    private Node firstNode;
    private Node secondNode;
    Rectangle2D rectangle;
    public Edge(Node node1,Node node2)
    {   this.firstNode =node1;
        this.secondNode =node2;
        countAngles();
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public void setSecondNode(Node secondNode) {
        this.secondNode = secondNode;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }

    public void countAngles()
    {int deltaX=(firstNode.getCenterX()-secondNode.getCenterX());
     int deltaY=(firstNode.getCenterY()-secondNode.getCenterY());
     double angle=Math.atan(deltaX/deltaY)*180/Math.PI;
     System.out.println("----"+deltaX+"-----"+deltaY+"-----"+angle);

    }
    public void render(Graphics2D graphics2D)
    {
        graphics2D.setColor(Color.GRAY);
        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.drawLine(firstNode.getCenterX()+15, firstNode.getCenterY()+15, secondNode.getCenterX()+15, secondNode.getCenterY()+15);
      //  graphics2D.fillPolygon(new int [] {firstNodePositionX, firstNodePositionX-10, secondNodePositionX,secondNodePositionX+10},
      //          new int [] {firstNodePositionY, firstNodePositionY+10, secondNodePositionY,secondNodePositionY-10}, 4);


    }
}
