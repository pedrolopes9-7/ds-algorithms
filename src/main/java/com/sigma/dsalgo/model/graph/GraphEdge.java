package com.sigma.dsalgo.model.graph;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GraphEdge {
    Integer sourceKey;
    Integer destinationKey;
    BigDecimal weight;

    public GraphEdge(Integer sourceKey, Integer destination, BigDecimal weight) {
        this.sourceKey = sourceKey;
        this.destinationKey = destination;
        this.weight = weight;
    }
}
