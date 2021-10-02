package com.sigma.dsalgo.model.graph

import spock.lang.Specification

class GraphTest extends Specification {

    def " create the graph correctly"(){
        when:
        def graph = Graph.random()

        then:
        graph.adjacencyMap.get(0).get(0).destinationKey == 1
        graph.adjacencyMap.get(0).get(0).destinationEdgeWeight == 2.0
    }
}
