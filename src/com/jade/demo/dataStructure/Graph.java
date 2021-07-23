package com.jade.demo.dataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

    private final int mVertexCount;
    private final Map<Integer, List<Edge>> mEdgeMap;

    public Graph(int vertexCount) {
        this.mVertexCount = vertexCount;
        mEdgeMap = new HashMap<>();
    }

    public void addEdge(int startVertex, int endVertex, int value) {
        final Edge edge = new Edge(startVertex, endVertex, value);
        if (mEdgeMap.containsKey(startVertex)) {
            mEdgeMap.get(startVertex).add(edge);
        } else {
            List<Edge> edges = new LinkedList<>();
            edges.add(edge);
            mEdgeMap.put(startVertex, edges);
        }
    }

    public List<Edge> getEdgeList(int startVertex) {
        return mEdgeMap.get(startVertex);
    }

    public int getVertexCount() {
        return mVertexCount;
    }

    public static class Edge {
        public final int mStartVertex;
        public final int mEndVertex;
        public final int mValue;

        public Edge(int startVertex, int endVertex, int value) {
            mStartVertex = startVertex;
            mEndVertex = endVertex;
            mValue = value;
        }
    }
}
