package com.sigma.dsalgo.util.graph;

import com.sigma.dsalgo.exception.GraphFormatNotValidException;
import com.sigma.dsalgo.model.graph.Graph;
import com.sigma.dsalgo.model.graph.GraphNode;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@UtilityClass
public class GraphUtil {

    public static List<Integer> topologicalSort(Graph graph) throws GraphFormatNotValidException {

        if (graph.isCyclic() || hasCycle(graph)) {
            throw new GraphFormatNotValidException("Graph contains cycle. Graph must be a DAG to be topologically sorted.");
        }

        List<Integer> sorted = new ArrayList<>();
        boolean[] visitedNodes = initializeVisitedArray(graph);
        Map<Integer, List<GraphNode>> graphAdjacencyMap = graph.getAdjacencyMap();

        int reverseIndexSortedArray = graphAdjacencyMap.keySet().size();
        int nextIndex = reverseIndexSortedArray - 1;

        for (Integer vertex : graphAdjacencyMap.keySet()) {
            if (!visitedNodes[vertex]) {
                nextIndex = depthFirstSearch(nextIndex, vertex, visitedNodes, sorted, graphAdjacencyMap);
            }
        }

        return sorted;
    }

    private static int depthFirstSearch(int nextIndex, Integer vertex, boolean[] visitedNodes, List<Integer> sorted, Map<Integer, List<GraphNode>> graphAdjacencyMap) {

        visitedNodes[vertex] = true;

        List<GraphNode> neighborhood = graphAdjacencyMap.get(vertex);

        for (GraphNode neighbor : neighborhood) {
            if (!visitedNodes[neighbor.getDestinationKey()]) {
                depthFirstSearch(nextIndex, neighbor.getDestinationKey(), visitedNodes, sorted, graphAdjacencyMap);
            }
        }

        sorted.add(vertex);
        return nextIndex - 1;
    }

    public static boolean hasCycle(Graph graph) {

        Map<Integer, List<GraphNode>> graphAdjacencyMap = graph.getAdjacencyMap();

        boolean[] visitedNodes = initializeVisitedArray(graph);
        boolean[] inCurrentRecursionStack = new boolean[graphAdjacencyMap.size()];

        for (Integer node : graphAdjacencyMap.keySet()) {
            if (hasCycle(visitedNodes, inCurrentRecursionStack, node, graphAdjacencyMap)) {
                graph.setCyclic(true);
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

    private static boolean[] initializeVisitedArray(Graph graph) {
        return new boolean[graph.getAdjacencyMap().size()];
    }
}
