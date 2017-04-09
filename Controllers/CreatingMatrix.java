package com.company.Controllers;

import com.company.elementsOfGraph.Edge;
import com.company.elementsOfGraph.Graph;
import com.company.elementsOfGraph.Node;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex o n 08.04.2017.
 */
public class CreatingMatrix {
    Graph graph;
    String[][] matr;
    int length;
    public CreatingMatrix(Graph graph){
        length=graph.getNodeList().size();
        matr=new String[length+1][length+1];
        this.graph=graph;
        for (int i=0; i<length+1;i++)
            for (int j=0; j<length+1;j++)
                matr[i][j]="0";
    }

    public void createMatr(){
        int k=1;
        for(Node node: graph.getNodeList()){
            matr[k][0]=node.getIdentificator();
            matr[0][k]=node.getIdentificator();
            k++;
        }
        for (int i=1; i<length+1;i++){
            for(Edge edge: graph.getEdgeList()) {
                if(matr[i][0]==edge.getFirstNode().getIdentificator()) {
                    for (int j=1; j<length+1;j++)
                    if(matr[0][j]==edge.getSecondNode().getIdentificator()) {
                        matr[i][j]=edge.getWeigth();
                    }
                }
                if(matr[i][0]==edge.getSecondNode().getIdentificator()) {
                    for (int j=1; j<length+1;j++)
                        if(matr[0][j]==edge.getFirstNode().getIdentificator()) {
                            matr[i][j]=edge.getWeigth();
                        }
                }
            }
        }
        for (int i=0; i<length+1;i++){
            for (int j=0; j<length+1;j++)
                System.out.print(matr[i][j]+" ");
            System.out.print("\n");
        }
        findMinPath();
    }

    public void findMinPath()
    {
        int VERTEXES=length;
        int infinity=1000;                     // Бесконечность
        int p= VERTEXES;				// Количество вершин в графе
        int a[][]=new int[length][length];
        /*          {{0,1,0,0,1,3},{  // Матрица смежности графа
                    1,0,5,0,0,1},{
                    0,5,0,5,20,1},{
                    0,0,5,0,3,2},{
                    1,0,20,3,0,10},{
                    3,1,1,2,10,0 }};*/
        for (int i = 1; i < length+1; i++)
        {
            for (int j = 1; j < length+1; j++) {
                a[i - 1][j - 1] = Integer.parseInt(matr[i][j]);
                System.out.print(a[i - 1][j - 1]+" ");
            }
            System.out.print("\n");
        }
        // Будем искать путь из вершины s в вершину g
        String first=JOptionPane.showInputDialog ("Введите идентификатор первой вершины");
        String second=JOptionPane.showInputDialog ("Введите идентификатор второй вершины");
        int s=0;
        int g=0;
                   		// Номер конечной вершины
        for(int i=1;i<length+1;i++)
        {
            if(first.equalsIgnoreCase(matr[i][0]))
            s=i-1;
            if(second.equalsIgnoreCase(matr[i][0]))
            g=i-1;
            System.out.println(matr[i][0]+" "+first+" "+second);
        }
        // cout<<"Введите s: ";  	// Номер может изменяться от 0 до p-1
        // cin>>s;
        //  cout<<"Введите g: ";
        //  cin>>g;
        int x[]=new int[VERTEXES]; //Массив, содержащий единицы и нули для каждой вершины,
        // x[i]=0 - еще не найден кратчайший путь в i-ю вершину,
        // x[i]=1 - кратчайший путь в i-ю вершину уже найден
        int t[]=new int[VERTEXES];  //t[i] - длина кратчайшего пути от вершины s в i
        int h[]=new int[VERTEXES];  //h[i] - вершина, предшествующая i-й вершине
        // на кратчайшем пути

        // Инициализируем начальные значения массивов
        int u;		    // Счетчик вершин
        for (u=0;u<p;u++)
        {
            t[u]=infinity; //Сначала все кратчайшие пути из s в i
            //равны бесконечности
            x[u]=0;        // и нет кратчайшего пути ни для одной вершины
        }
        h[s]=0; // s - начало пути, поэтому этой вершине ничего не предшествует
        t[s]=0; // Кратчайший путь из s в s равен 0
        x[s]=1; // Для вершины s найден кратчайший путь
        int v=s;    // Делаем s текущей вершиной

        while(true)
        {
            // Перебираем все вершины, смежные v, и ищем для них кратчайший путь
            for(u=0;u<p;u++)
            {
                if(a[v][u]==0)continue; // Вершины u и v несмежные
                if(x[u]==0 && t[u]>t[v]+a[v][u]); //Если для вершины u еще не
                //найден кратчайший путь
                // и новый путь в u короче чем
                //старый, то
                {
                    t[u]=t[v]+a[v][u];	//запоминаем более короткую длину пути в
                    //массив t и
                    h[u]=v;	//запоминаем, что v->u часть кратчайшего
                    //пути из s->u
                }
            }

            // Ищем из всех длин некратчайших путей самый короткий
            int w=infinity;  // Для поиска самого короткого пути
            v=-1;            // В конце поиска v - вершина, в которую будет
            // найден новый кратчайший путь. Она станет
            // текущей вершиной
            for(u=0;u<p;u++) // Перебираем все вершины.
            {
                if(x[u]==0 && t[u]<w) // Если для вершины не найден кратчайший
                // путь и если длина пути в вершину u меньше
                // уже найденной, то
                {
                    v=u; // текущей вершиной становится u-я вершина
                    w=t[u];
                }
            }
            if(v==-1)
            {
                System.out.println("Нет пути из вершины "+s+" в вершину "+g+".");
                //cout<<"Нет пути из вершины "<<s<<" в вершину "<<g<<"."<<endl;
                break;
            }
            if(v==g) // Найден кратчайший путь,
            {        // выводим его
                System.out.println("Путь из "+s+" в вершину "+g+".");
                u=g;
                Node[] tract=new Node[15];
                int coll=0;
                while(u!=s)
                {
                    System.out.print(matr[0][u+1]+" ");
                    for(Node node: graph.getNodeList())
                    {
                        if(node.getIdentificator().equalsIgnoreCase(matr[0][u+1]))
                        {node.setColorOfNode(Color.BLUE);
                            tract[coll]=node;
                            coll++;
                        }

                    }
                    u=h[u];


                }
                for(Node node: graph.getNodeList()){
                if(node.getIdentificator().equalsIgnoreCase(matr[0][s+1])){
                    node.setColorOfNode(Color.BLUE);
                    tract[coll]=node;
                    coll++;
                     }
                }
                System.out.println(" "+matr[0][s+1]+". Длина пути - "+t[g]+"\n");

                for(int i=1;i<coll;i++){
                for(Edge edge: graph.getEdgeList()){
                    System.out.print(edge.getFirstNode().getIdentificator()+" "+edge.getSecondNode().getIdentificator()+
                    "--"+tract[i-1].getIdentificator()+" "+tract[i].getIdentificator()+"\n");

                    if(edge.getFirstNode().getIdentificator().equalsIgnoreCase(tract[i-1].getIdentificator())&&
                            edge.getSecondNode().getIdentificator().equalsIgnoreCase(tract[i].getIdentificator()))
                        edge.setColor(Color.blue);
                    if(edge.getFirstNode().getIdentificator().equalsIgnoreCase(tract[i].getIdentificator())&&
                            edge.getSecondNode().getIdentificator().equalsIgnoreCase(tract[i-1].getIdentificator()))
                        edge.setColor(Color.blue);

                }
                }

                break;
            }
            x[v]=1;
        }
    }

}
