package domain.list

class MyLinkedList<T> : MyList<T>() {

    private var head: Node? = null
    private var tail: Node? = head


    override val elements: List<T>
        get() {
            return if (head != null) {
                val result = mutableListOf<T>()
                var currNode = head

                while (true) {
                    currNode!!.value?.let { result.add(it) }
                    if (currNode.hasNext())
                        currNode = currNode.nextNode
                    else
                        break
                }

                result
            } else
                listOf()
        }

    override fun clear() {
        head?.clearChildren()
    }

    override fun add(element: T) {
        val newNode = Node(element)
        tail?.add(newNode) ?: init(newNode)
    }

    private fun init(newNode: Node) {
        head = newNode
        //tail = head
    }

    fun addOnStart(element: T) {
        val newNode = Node(element)
        head?.let { newNode.add(it) } ?: init(newNode)
    }

    override fun isEmpty(): Boolean {
        return head == null
    }

    inner class Node(var value: T?, var nextNode: Node? = null) {
        fun add(newNode: Node) {
            nextNode = newNode
        }

        fun hasNext(): Boolean = nextNode == null

        fun clearChildren() {
            nextNode?.clearChildren()
            this.value = null
        }
    }
}
