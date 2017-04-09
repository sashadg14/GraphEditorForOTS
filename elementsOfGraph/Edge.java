package com.company.elementsOfGraph;

import javafx.geometry.Rectangle2D;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alex on 19.02.2017.
 */
public class Edge {
    private Node firstNode;
    private Node secondNode;
    private Color color;
    private boolean isActive=false;
    private String weigth="";
    private boolean visited=false;
    public Edge(Node node1,Node node2)
    {   this.firstNode =node1;
        this.secondNode =node2;
        color=Color.gray;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
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

    public void render(Graphics2D graphics2D)
    {
        graphics2D.setColor(Color.gray);
        if(isActive()){
            graphics2D.setColor(Color.orange);
        }
        if(isVisited()){
            graphics2D.setColor(Color.cyan);
        }
        if(Color.blue==color)
            graphics2D.setColor(Color.blue);
        graphics2D.setStroke(new BasicStroke(10));
        if (getFirstNode()!=getSecondNode())
            graphics2D.drawLine(getFirstNode().getCenterX() + 15, getFirstNode().getCenterY() + 15, getSecondNode().getCenterX() + 15, getSecondNode().getCenterY() + 15);
        else {
            graphics2D.fillOval(getFirstNode().getCenterX() + 10, getFirstNode().getCenterY() - 15, 60, 60);
            graphics2D.setColor(Color.WHITE);
            graphics2D.fillOval(getFirstNode().getCenterX() + 20, getFirstNode().getCenterY() - 5, 40, 40);
        }

        graphics2D.setColor(Color.blue);
        graphics2D.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 20));
        graphics2D.drawString(getWeigth(), (getFirstNode().getCenterX() + 30 + getSecondNode().getCenterX() + 30) / 2,
                (getFirstNode().getCenterY() + 30 + getSecondNode().getCenterY() + 30) / 2);

        //  graphics2D.fillPolygon(new int [] {firstNodePositionX, firstNodePositionX-10, secondNodePositionX,secondNodePositionX+10},
      //          new int [] {firstNodePositionY, firstNodePositionY+10, secondNodePositionY,secondNodePositionY-10}, 4);

    }
    private boolean isEdgeHaveActiveNode()
    {
        return (firstNode.isEntered() || secondNode.isEntered());
    }
    public void setEntered(int posX, int posY)
    {   //System.out.println(firstNode.getCenterX()+" "+secondNode.getCenterX()+" "+posX);
        double H;
        color=Color.gray;
        isActive=false;
      // if(((firstNode.getCenterX()-posX)<-15&(firstNode.getCenterY()-posY)<-15)||((posX-secondNode.getCenterX())<-15&(posY-secondNode.getCenterY())<-15))
        if(((posX<firstNode.getCenterX()+15&posX>secondNode.getCenterX()+15)||(posX<secondNode.getCenterX()+15&posX>firstNode.getCenterX()+15))&!isEdgeHaveActiveNode())
       {
           H = (((firstNode.getCenterY() - secondNode.getCenterY()) * posX + (secondNode.getCenterX() - firstNode.getCenterX()) * posY +
                   (firstNode.getCenterX() * secondNode.getCenterY() - secondNode.getCenterX() * firstNode.getCenterY())) /
                   Math.pow((secondNode.getCenterX() - firstNode.getCenterX()) * (secondNode.getCenterX() - firstNode.getCenterX()) +
                           (secondNode.getCenterY() - firstNode.getCenterY()) * (secondNode.getCenterY() - firstNode.getCenterY()), 0.5));

       if(Math.abs(H)<15)
       {
        color=Color.orange;
        isActive=true;
       }
               // else color=Color.gray;
              //  System.out.println(" H===="+H);
    }

    }
}
