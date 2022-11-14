package domain.list

class MyLinkedList<T>(elements: Collection<T> = listOf()) : MyList<T>(elements) {

    private var _head: Node? = null
    val head: Node?
        get() = _head

    private var _tail: Node? = null
    val tail: Node?
        get() = _tail


    override val toList: List<T>
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

    inner class Node(var value: T, var nextNode: Node? = null) {
        fun add(newNode: Node) {
            nextNode = newNode
        }

        fun hasNext(): Boolean = nextNode != null

        fun clearChildren() {
            nextNode?.clearChildren()
            nextNode = null
        }

        fun thisOrChildrenContains(element: T): Boolean {
            val currentNode = this
            while (true) {
                return if (currentNode.value == element)
                    true
                else {
                    currentNode.nextNode?.thisOrChildrenContains(element) ?: false
                }
            }
        }
    }

    override val size: Int
        get() = toList.size

    override fun contains(element: T): Boolean {
        return _head?.thisOrChildrenContains(element) ?: false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        var contains = false
        elements.map {
            contains = _head?.thisOrChildrenContains(it) ?: false
        }
        return contains
    }

    override fun iterator(): Iterator<T> {
        return if (!isEmpty()) {
            object : Iterator<T> {
                private var currentNode = _head!!

                override fun hasNext(): Boolean {
                    return currentNode.hasNext()
                }

                override fun next(): T {
                    return currentNode.value.also {
                        if (hasNext())
                            currentNode = currentNode.nextNode!!
                    }
                }
            }
        } else
            toList.iterator()
    }
}
