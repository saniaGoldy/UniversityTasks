package domain.dataStructures

class BinaryTree {
    var rootNode: Node<Int>? = null
    private val comparator = { oldValue: Int, newValue: Int ->
        newValue <= oldValue
    }

    fun insert(value: Int) {
        if (rootNode == null) {
            rootNode = Node(value, comparator = comparator)
        } else {
            rootNode?.insert(value)
        }
    }

    fun getAsList(): List<Int> {
        return rootNode?.getChildrenAndValueSorted() ?: listOf()
    }
}