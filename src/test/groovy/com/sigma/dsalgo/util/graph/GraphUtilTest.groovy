package com.sigma.dsalgo.util.graph

import com.sigma.dsalgo.model.graph.Graph
import spock.lang.Specification

class GraphUtilTest extends Specification {
    //TODO:: better tests
    def "HasCycle"() {
        given:
        Graph graph = Graph.random()

        when:
        def result = GraphUtil.hasCycle(graph)

        then:
        result == true
    }
}
