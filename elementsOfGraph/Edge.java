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
    Rectangle2D rectangle;
    Color color;
    public Edge(Node node1,Node node2)
    {   this.firstNode =node1;
        this.secondNode =node2;
        color=Color.gray;
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
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.drawLine(firstNode.getCenterX()+15, firstNode.getCenterY()+15, secondNode.getCenterX()+15, secondNode.getCenterY()+15);
      //  graphics2D.fillPolygon(new int [] {firstNodePositionX, firstNodePositionX-10, secondNodePositionX,secondNodePositionX+10},
      //          new int [] {firstNodePositionY, firstNodePositionY+10, secondNodePositionY,secondNodePositionY-10}, 4);
    }

    public void isEntered(int posX, int posY)
    {
         //       double H  = Math.pow((firstNode.getCenterX()+15-posX)*(firstNode.getCenterX()+15-posX) + (firstNode.getCenterY()+15-posY)*(firstNode.getCenterY()+15-posY),0.5)+
        //        Math.pow((posX-secondNode.getCenterX()+15)*(posX-secondNode.getCenterX()+15) + (posY-secondNode.getCenterY()+15)*(posY-secondNode.getCenterY()+15),0.5) -
        //        Math.pow((firstNode.getCenterX()-secondNode.getCenterX())*(firstNode.getCenterX()-secondNode.getCenterX()) + (firstNode.getCenterY()-secondNode.getCenterY())*(firstNode.getCenterY()-secondNode.getCenterY()),0.5);
       /* double A= Math.pow((firstNode.getCenterX()+15-posX)*(firstNode.getCenterX()+15-posX) + (firstNode.getCenterY()+15-posY)*(firstNode.getCenterY()+15-posY),0.5);
        double B=Math.pow((posX-secondNode.getCenterX()+15)*(posX-secondNode.getCenterX()+15) + (posY-secondNode.getCenterY()+15)*(posY-secondNode.getCenterY()+15),0.5);
        double C= Math.pow((firstNode.getCenterX()-secondNode.getCenterX())*(firstNode.getCenterX()-secondNode.getCenterX()) + (firstNode.getCenterY()-secondNode.getCenterY())*(firstNode.getCenterY()-secondNode.getCenterY()),0.5);
        double poluPer=(A+B+C)/2;
        double H=Math.pow(Math.abs(poluPer*(poluPer-A)*(poluPer-B)*(poluPer-C)),0.5)*2/C;*/
        double H=-1;
      // if(((firstNode.getCenterX()-posX)<-15&(firstNode.getCenterY()-posY)<-15)||((posX-secondNode.getCenterX())<-15&(posY-secondNode.getCenterY())<-15))
       {
           H = (((firstNode.getCenterY() - secondNode.getCenterY()) * posX + (secondNode.getCenterX() - firstNode.getCenterX()) * posY +
                   (firstNode.getCenterX() * secondNode.getCenterY() - secondNode.getCenterX() * firstNode.getCenterY())) /
                   Math.pow((secondNode.getCenterX() - firstNode.getCenterX()) * (secondNode.getCenterX() - firstNode.getCenterX()) +
                           (secondNode.getCenterY() - firstNode.getCenterY()) * (secondNode.getCenterY() - firstNode.getCenterY()), 0.5));
       }
       if(Math.abs(H)<15)
                    color=Color.orange;
                else color=Color.gray;
                //System.out.println("A="+A+"B="+B+"C="+C+" H===="+H);
                System.out.println(" H===="+H);

    }
}
