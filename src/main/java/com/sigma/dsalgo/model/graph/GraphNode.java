package com.sigma.dsalgo.model.graph;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GraphNode {
    private Integer destinationKey;
    private BigDecimal destinationEdgeWeight;

    public GraphNode(Integer destinationKey, BigDecimal destinationEdgeWeight) {
        this.destinationKey = destinationKey;
        this.destinationEdgeWeight = destinationEdgeWeight;
    }
}
