package com.sigma.dsalgo.model.tree.iterator

import spock.lang.Specification

import static ObjectMother.TreeType
import static ObjectMother.buildBinarySearchTree

class PreOrderIteratorTest extends Specification {
    def "constructor - happy path adds the elements pre order traversal"() {
        given:
        def tree = buildBinarySearchTree(1, TreeType.INTEGER)

        and:
        tree.insert(10)
        tree.insert(2)
        tree.insert(4)
        tree.insert(20)

        when:
        def iterator = new PreOrderIterator(tree)

        then:
        iterator.preOrderList == [50, 10, 2, 4, 20]
    }

    def "hasNext - happy path when tree has at least one element"() {
        given:
        def tree = buildBinarySearchTree(1, TreeType.INTEGER)

        when:
        def iterator = new PreOrderIterator(tree)

        then:
        iterator.hasNext()
    }

    def "next - happy path correctly removes next element"() {
        given:
        def tree = buildBinarySearchTree(1, TreeType.INTEGER)

        when:
        def iterator = new PreOrderIterator(tree)

        and:
        def result = iterator.next()

        then:
        result == tree.root.data

        and:
        !iterator.hasNext()
    }
}
