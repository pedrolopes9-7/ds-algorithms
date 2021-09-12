package com.sigma.dsalgo.model.tree.iterator

import spock.lang.Specification

import static ObjectMother.*

class InOrderIteratorTest extends Specification {

    def "constructor - happy path adds the elements in order traversal"() {
        given:
        def tree = buildBinarySearchTree(1, TreeType.INTEGER)

        and:
        tree.insert(10)
        tree.insert(2)
        tree.insert(4)
        tree.insert(20)

        when:
        def iterator = new InOrderIterator(tree)

        then:
        iterator.inOrderList == [2, 4, 10, 20, 50]
    }

    def "hasNext - happy path when tree has at least one element"() {
        given:
        def tree = buildBinarySearchTree(1, TreeType.INTEGER)

        when:
        def iterator = new InOrderIterator(tree)

        then:
        iterator.hasNext()
    }

    def "next - happy path correctly removes next element"() {
        given:
        def tree = buildBinarySearchTree(1, TreeType.INTEGER)

        when:
        def iterator = new InOrderIterator(tree)

        and:
        def result = iterator.next()

        then:
        result == tree.root.data

        and:
        !iterator.hasNext()
    }
}
