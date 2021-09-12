package com.sigma.dsalgo.model.iterator

import spock.lang.Specification

import static ObjectMother.*

class InOrderIteratorTest extends Specification {

    def "constructor"() {
        given:
        def tree = buildBinarySearchTree(0, TreeType.INTEGER)

        and:
        tree.insert(10)
        tree.insert(2)
        tree.insert(4)
        tree.insert(20)

        when:
        def iterator = new InOrderIterator(tree)

        then:
        iterator.inOrderList == [2, 4, 5, 7, 20]
    }

    def "hasNext"() {

    }

    def "next"() {
    }
}
