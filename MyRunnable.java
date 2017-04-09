package com.company;

import com.company.elementsOfGraph.Edge;
import com.company.elementsOfGraph.Graph;
import com.company.elementsOfGraph.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alex on 15.03.2017.
 */
public class MyRunnable implements Runnable {
    private Graph graph;
    public MyRunnable(Graph graph,Node beginNode, Node endNode)
    {
        this.graph=graph;
    }
    @Override
    public void run() {

        List<Node> visitedNodes=new ArrayList<Node>();
        for(Node node: graph.getNodeList())
        {
            dfs(node,node);
            break;
        }
    }
    public int chislo=0;
    public void dfs(Node previousNode, Node currentNode)
    {   //graph.renderAllElements();
        System.out.println(currentNode.getIdentificator());
        try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
      //  currentNode.setVisited(true);
        currentNode.setColorOfNode(Color.pink);
        Node nextNode = null;
        Iterator<Edge> edgeIterator=graph.getEdgeList().iterator();
        while (edgeIterator.hasNext())
        {   Edge edge = edgeIterator.next();
            if(currentNode==edge.getFirstNode())
            {
                if(!edge.isVisited())
                {
                System.out.println("its first");
                nextNode=edge.getSecondNode();
                edge.setColor(Color.cyan);
                edge.setWeigth(Integer.toString(chislo));
                edge.setVisited(true);chislo++;
                }
            } else if(currentNode==edge.getSecondNode())
            {
                if(!edge.isVisited())
            {   System.out.println("its second");
                nextNode=edge.getFirstNode();
                edge.setColor(Color.cyan);
                edge.setWeigth(Integer.toString(chislo));
                edge.setVisited(true);chislo++;
            }
            }
            if (nextNode==previousNode)
                continue;
            if (nextNode!=null)
            if (!nextNode.isVisited())
            dfs(currentNode,nextNode);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        notifyAll();
    }

}
