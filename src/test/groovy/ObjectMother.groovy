import com.sigma.dsalgo.model.tree.concrete.BinarySearchTree

import java.util.concurrent.ThreadLocalRandom

class ObjectMother {

    static final enum TreeType {
        INTEGER, DOUBLE, FLOAT, DATE, DATETIME, INSTANT
    }

    //First value of tree for any Type will always be defaulted to (maxRange - minRange) / 2
    static buildBinarySearchTree(size = 1, type = TreeType.INTEGER, minRange = 0, maxRange = 100) {
        def tree = null

        switch (type) {
            case TreeType.INTEGER:
                tree = buildIntegerBinarySearchTree(size, minRange, maxRange)
                break
            case TreeType.DOUBLE:
                tree = buildDoubleBinarySearchTree(size, minRange, maxRange)
                break
            case TreeType.FLOAT:
                tree = buildFloatBinarySearchTree(size, minRange, maxRange)
                break
        }

        tree
    }

    private static buildDoubleBinarySearchTree(size, minRange, maxRange) {
        def rootValue = (maxRange - minRange) / 2 as Double
        def tree = new BinarySearchTree(rootValue)

        for (int i = 1; i < size; i++) {
            def nextRandom = ThreadLocalRandom.current().nextDouble(minRange, maxRange)
            tree.insert(nextRandom)
        }

        tree
    }

    private static buildFloatBinarySearchTree(size, minRange, maxRange) {
        def rootValue = (maxRange - minRange) / 2 as Float
        Random random = new Random()

        def tree = new BinarySearchTree(rootValue)

        for (int i = 1; i < size; i++) {
            def nextRandom = minRange + random.nextFloat() * (maxRange - minRange) as Float
            tree.insert(nextRandom)
        }

        tree
    }

    private static buildIntegerBinarySearchTree(size, minRange, maxRange) {
        def rootValue = (maxRange - minRange) / 2 as Integer
        def tree = new BinarySearchTree(rootValue)

        for (int i = 1; i < size; i++) {
            def nextRandom = ThreadLocalRandom.current().nextInt(minRange, maxRange)
            tree.insert(nextRandom)
        }

        tree
    }

    static <T> T applyProperties(props, T object) {
        if (props) {
            props.each { k, v -> object[k] = v }
        }
        object
    }
}
