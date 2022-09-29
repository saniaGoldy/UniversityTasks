package domain.dataStructures

/** [comparator] have to return [true] if new value should go in the left node otherwise [false]
 *
 * [leftNode] and [rightNode] are [null] by default
 */
data class Node<T>(
    val value: T,
    var leftNode: Node<T>? = null,
    var rightNode: Node<T>? = null,
    val comparator: (thisNodeValue: T, newValue: T) -> Boolean
) {
    fun insert(value: T) {
        Node(value, comparator = comparator).let { node ->
            if (comparator(this.value, value)) {
                if (leftNode == null) {
                    leftNode = node
                } else {
                    leftNode?.insert(value)
                }
            } else {
                if (rightNode == null){
                    rightNode = node
                }else{
                    rightNode?.insert(value)
                }
            }
        }
    }

    /**
     * @return list of all nodes to the left of this node + [value] + list of all nodes to the right
     * in ascending order (order depends on [comparator])
     */
    fun getChildrenAndValueSorted(): List<T> {
        val leftValues = leftNode?.getChildrenAndValueSorted() ?: listOf()
        val rightValues = rightNode?.getChildrenAndValueSorted() ?: listOf()
        return leftValues.plus(value).plus(rightValues)
    }
}