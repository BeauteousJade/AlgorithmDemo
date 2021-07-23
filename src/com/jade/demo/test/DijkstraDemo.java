package com.jade.demo.test;

import com.jade.demo.dataStructure.Graph;

import java.util.*;

public class DijkstraDemo {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 3, 3);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 6, 1);
        graph.addEdge(2, 5, 2);
        graph.addEdge(3, 6, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 2);
        graph.addEdge(6, 2, 1);
        graph.addEdge(6, 4, 0);
        graph.addEdge(6, 2, 1);
        DijkstraDemo demo = new DijkstraDemo();
        demo.dijkstra(graph, 1, 5);
    }

    public void dijkstra(Graph graph, int startVertex, int targetVertex) {
        final int vertexCount = graph.getVertexCount();
        final boolean[] visited = new boolean[vertexCount + 1];
        final int[] vertexDistance = new int[vertexCount + 1];
        final Map<Integer, Integer> preVertex = new HashMap<>();
        Arrays.fill(vertexDistance, Integer.MAX_VALUE);
        Queue<Integer> vertexQueue = new LinkedList<>();
        vertexQueue.add(startVertex);
        visited[startVertex] = true;
        vertexDistance[startVertex] = 0;
        while (!vertexQueue.isEmpty()) {
            int currentVertex = vertexQueue.poll();
            List<Graph.Edge> edgeList = graph.getEdgeList(currentVertex);
            for (int i = 0; edgeList != null && i < edgeList.size(); i++) {
                Graph.Edge edge = edgeList.get(i);
                if (vertexDistance[edge.mStartVertex] + edge.mValue < vertexDistance[edge.mEndVertex]) {
                    preVertex.put(edge.mEndVertex, edge.mStartVertex);
                    vertexDistance[edge.mEndVertex] = vertexDistance[edge.mStartVertex] + edge.mValue;
                }
                if (!visited[edge.mEndVertex]) {
                    visited[edge.mEndVertex] = true;
                    vertexQueue.offer(edge.mEndVertex);
                }
            }
        }
        System.out.println(String.format("最新的路径：%s", vertexDistance[targetVertex]));
        System.out.print(startVertex);
        print(startVertex, targetVertex, preVertex);
    }

    public void print(int startVertex, int endVertex, Map<Integer, Integer> preVertex) {
        if (startVertex == endVertex) {
            return;
        }
        print(startVertex, preVertex.get(endVertex), preVertex);
        System.out.print("->" + endVertex);
    }
}
