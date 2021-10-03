package com.sigma.dsalgo.util.graph;

import com.sigma.dsalgo.exception.GraphFormatNotValidException;
import com.sigma.dsalgo.model.graph.Graph;
import com.sigma.dsalgo.model.graph.GraphNode;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
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

        for (Integer vertex : graphAdjacencyMap.keySet()) {
            if (!visitedNodes[vertex]) {
                List<Integer> dfsOrder = new ArrayList<>();
                depthFirstSearch(vertex, visitedNodes, dfsOrder, graphAdjacencyMap);

                for (Integer nodeInDfs : dfsOrder) {
                    sorted.add(reverseIndexSortedArray, nodeInDfs);
                    reverseIndexSortedArray--;
                }
            }
        }

        return sorted;
    }

    private static void depthFirstSearch(Integer vertex, boolean[] visitedNodes, List<Integer> dfsOrder, Map<Integer, List<GraphNode>> graphAdjacencyMap) {

        visitedNodes[vertex] = true;

        List<GraphNode> neighborhood = graphAdjacencyMap.get(vertex);

        for (GraphNode neighbor : neighborhood) {
            if (!visitedNodes[neighbor.getDestinationKey()]) {
                depthFirstSearch(neighbor.getDestinationKey(), visitedNodes, dfsOrder, graphAdjacencyMap);
            }
        }

        dfsOrder.add(vertex);
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
