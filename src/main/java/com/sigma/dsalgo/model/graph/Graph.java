package com.sigma.dsalgo.model.graph;

import lombok.Data;

import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class Graph {

    private Map<Integer, List<GraphNode>> adjacencyMap;
    private boolean isCyclic;
    private static final int defaultVertexSize = 10;
    private static final int defaultEdgeSize = 10;

    public static Graph randomDag() {
        //TODO:: implement random DAG generation
        return null;
    }

    public static Graph random() {
        List<GraphEdge> allEdges = new ArrayList<>();

        for (int i = 0; i < defaultEdgeSize; i++) {
            int randomSource = ThreadLocalRandom.current().nextInt(0, defaultVertexSize);
            int randomDestination = ThreadLocalRandom.current().nextInt(0, defaultVertexSize);
            BigDecimal randomWeight = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(0, 15)).round(new MathContext(4));

            allEdges.add(new GraphEdge(randomSource, randomDestination, randomWeight));
        }

        Graph graph = new Graph(allEdges);
        graph.setCyclic(false);
        eliminateMultiEdges(graph);

        return graph;
    }

    private static void eliminateMultiEdges(Graph graph) {
        //TODO:: eliminate multi edges
    }

    public static Graph of(File edgesFile) {
        //TODO:: can be useful in the future, to work with big instances and avoid generation methods
        return null;
    }

    private Graph(List<GraphEdge> edges) {

        adjacencyMap = new HashMap<>();

        allocateMapBySourceKey(edges);

        for (GraphEdge edge : edges) {
            adjacencyMap.get(edge.getSourceKey())
                    .add(new GraphNode(edge.getDestinationKey(), edge.getWeight()));
        }
    }

    private void allocateMapBySourceKey(List<GraphEdge> edges) {
        for (GraphEdge edge : edges) {
            adjacencyMap.putIfAbsent(edge.getSourceKey(), new LinkedList<>());
            adjacencyMap.putIfAbsent(edge.getDestinationKey(), new LinkedList<>());
        }
    }
}
