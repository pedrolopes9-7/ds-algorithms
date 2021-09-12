package com.sigma.dsalgo.model.tree.concrete

import spock.lang.Specification

import static ObjectMother.*

class BinarySearchTreeTest extends Specification {

    def "search - "() {
        given:
        def tree = buildBinarySearchTree(10, TreeType.INTEGER)

        and:
        tree.insert(5)

        when:
        def result = tree.search(5)

        then:
        result == 5
    }

    def "insert - "() {
        given:
        def tree = buildBinarySearchTree(10, TreeType.INTEGER)

        when:
        tree.insert(7)

        and:
        def result = tree.search(7)

        then:
        result == 7
    }

    def "delete - "() {
        given:
        def tree = buildBinarySearchTree(10, TreeType.INTEGER)

        and:
        tree.insert(7)

        when:
        tree.delete(7)

        and:
        def result = tree.search(7)

        then:
        result == null
    }
}
