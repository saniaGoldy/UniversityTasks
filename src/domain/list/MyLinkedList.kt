package domain.list

class MyLinkedList<T> : MyList<T>() {

    private var _head: Node? = null
    val head: Node?
        get() = _head

    private var _tail: Node? = null
    val tail: Node?
        get() = _tail


    override val elements: List<T>
        get() {
            return if (_head != null) {
                val result = mutableListOf<T>()
                var currNode = _head

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
        _head?.clearChildren()
        deletePointers()
    }

    private fun deletePointers() {
        _head = null
        _tail = null
    }

    override fun add(element: T) {
        val newNode = Node(element)
        if (_head != null && _tail != null) {
            _tail!!.add(newNode)
            _tail = newNode
        } else {
            init(newNode)
        }
    }

    private fun init(newNode: Node) {
        _head = newNode
        _tail = newNode
    }

    fun addOnStart(element: T) {
        val newNode = Node(element)
        if (_head != null && _tail != null) {
            newNode.add(_head!!)
            _head = newNode
        } else {
            init(newNode)
        }
    }

    override fun isEmpty(): Boolean {
        return _head == null
    }

    inner class Node(var value: T?, var nextNode: Node? = null) {
        fun add(newNode: Node) {
            nextNode = newNode
        }

        fun hasNext(): Boolean = nextNode != null

        fun clearChildren() {
            nextNode?.clearChildren()
            this.value = null
        }
    }
}
