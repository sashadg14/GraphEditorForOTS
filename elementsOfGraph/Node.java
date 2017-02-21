package com.company.elementsOfGraph;

import javafx.scene.paint.*;

import java.awt.*;
import java.awt.Color;

import static java.lang.Math.sqrt;

/**
 * Created by alex on 19.02.2017.
 */
public class Node {
    private int centerX;
    private int centerY;
    private Color colorOfNode;
    private boolean isActive=false;
    private boolean isEntered=false;

    public Node(int centerX,int centerY)
    {   colorOfNode=Color.BLACK;
        this.centerX=centerX;
        this.centerY=centerY;
    }
    public int getCenterX() {
        return centerX;
    }
    public int getCenterY() {
        return centerY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
        if(active)
            colorOfNode=Color.GREEN;
        else
            colorOfNode=Color.BLACK;
    }

    public boolean isEntered() {
        return isEntered;
    }

    public void setEntered(boolean entered) {
        isEntered = entered;
        if(entered)
            colorOfNode=Color.ORANGE;
        else
            colorOfNode=Color.BLACK;
    }

    public void render(Graphics2D graphics2D)
    {   graphics2D.setColor(colorOfNode);
        graphics2D.fillOval(centerX, centerY, 30, 30);
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(centerX+5, centerY+5, 20, 20);
    }
    public boolean isOverlapWithCursor(int posX, int posY)
    {
        if(sqrt((posX-centerX)*(posX-centerX)+(posY-centerY)*(posY-centerY))<30)
        return true;
        else return false;
    }
}
