package com.company.elementsOfGraph;

import java.awt.*;

/**
 * Created by alex on 19.02.2017.
 */
public class Node {
    private int centerX;
    private int centerY;
    public Node(int centerX,int centerY)
    {
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

    public void render(Graphics2D graphics2D)
    {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillOval(centerX, centerY, 30, 30);
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(centerX+5, centerY+5, 20, 20);
    }
}
