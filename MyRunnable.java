package com.company;

import com.company.elementsOfGraph.Graph;
import com.company.elementsOfGraph.Node;

/**
 * Created by alex on 15.03.2017.
 */
public class MyRunnable implements Runnable {
    private Graph graph;
    public MyRunnable(Graph graph)
    {
        this.graph=graph;
    }
    @Override
    public void run() {
        for(Node node: graph.getNodeList())
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ID "+node.getId());
        }
    }
}
