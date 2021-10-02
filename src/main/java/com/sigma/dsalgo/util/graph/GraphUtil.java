package com.sigma.dsalgo.util.graph;

import com.sigma.dsalgo.model.graph.Graph;
import com.sigma.dsalgo.model.graph.GraphNode;

import java.util.List;
import java.util.Map;

public class GraphUtil {
    public static boolean hasCycle(Graph graph) {

        Map<Integer, List<GraphNode>> graphAdjacencyMap = graph.getAdjacencyMap();

        boolean[] visitedNodes = new boolean[graphAdjacencyMap.size()];
        boolean[] inCurrentRecursionStack = new boolean[graphAdjacencyMap.size()];

        for (Integer node : graphAdjacencyMap.keySet()) {
            if (hasCycle(visitedNodes, inCurrentRecursionStack, node, graphAdjacencyMap)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(boolean[] visitedNodes, boolean[] nodesInRecursionStack, Integer node, Map<Integer, List<GraphNode>> graphAdjacencyMap) {

        if (nodesInRecursionStack[node]) {
            return true;
        }

        if (visitedNodes[node]) {
            return false;
        }

        visitedNodes[node] = true;

        nodesInRecursionStack[node] = true;

        List<GraphNode> neighbors = graphAdjacencyMap.get(node);

        for (GraphNode neighbor : neighbors) {
            if (hasCycle(visitedNodes, nodesInRecursionStack, neighbor.getDestinationKey(), graphAdjacencyMap)) {
                return true;
            }
        }
        nodesInRecursionStack[node] = false;
        return false;
    }
}
