package com.sigma.dsalgo.model.concrete

import spock.lang.Specification

class BinarySearchTreeTest extends Specification {
    //TODO :: create ObjectMother style mock factory

    def "search - "() {
        given:
        def tree = new BinarySearchTree(5)

        when:
        def result = tree.search(5)

        then:
        result == 5
    }

    def "insert - "() {
        given:
        def tree = new BinarySearchTree(6)

        when:
        tree.insert(7)
        tree.insert(2)
        tree.insert(4)
        tree.insert(20)

        and:
        def result = tree.search(7)

        then:
        result == 7
    }

    def "delete - "() {
        given:
        def tree = new BinarySearchTree(6)

        when:
        tree.insert(7)
        tree.insert(2)
        tree.insert(4)
        tree.insert(20)

        and:
        def result = tree.search(7)

        then:
        result == 7
    }
}
