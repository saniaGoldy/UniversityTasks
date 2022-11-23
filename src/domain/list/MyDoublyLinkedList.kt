package domain.list

class MyDoublyLinkedList<E> : MyList<E>() {
    private var _size = 0

    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    override val size: Int
        get() = _size

    fun getFirst() = head?.value

    fun getLast() = tail?.value

    fun removeFirst() = unlinkHead()

    fun removeLast() = unlinkTail()

    fun addFirst(element: E) {
        linkHead(element)
    }

    fun addLast(element: E) {
        linkTail(element)
    }

    override fun add(element: E) {
        linkTail(element)
    }

    /** add [elements] to list starting from specified [index] */
    fun <T> addAll(index: Int, elements: Array<T>): Boolean where T : E {
        validatePositionIndex(index)

        val numNew = elements.size
        if (numNew == 0) return false

        var prev: Node<E>?
        var next: Node<E>?
        when (index) {
            0 -> {
                next = head
                prev = null
            }
            _size -> {
                next = null
                prev = tail
            }
            else -> {
                next = getNodeById(index)
                prev = next.prev
            }
        }

        for (item in elements) {
            val e = item as E
            val newNode = Node<E>(prev, e, null)
            if (prev == null)
                head = newNode
            else
                prev.next = newNode
            prev = newNode
        }

        if (next == null) {
            tail = prev
        } else {
            prev!!.next = next
            next.prev = prev
        }

        _size += numNew
        return true
    }

    fun swapAfterId(id: Int) {
        validateElementIndex(id + 1)

        val firstNode = getNodeById(id)
        val secondNode = getNodeById(id + 1)

        swapNodes(firstNode, secondNode)

        if (id == 0) {
            head = secondNode
        } else if (id + 1 == _size) {
            tail = firstNode
        }
    }

    private fun swapNodes(
        firstNode: Node<E>,
        secondNode: Node<E>
    ) {
        firstNode.next = secondNode.next
        firstNode.prev = secondNode

        secondNode.next = firstNode
        secondNode.prev = firstNode.prev
    }

    fun remove(element: E): Boolean {
        var curr = head
        while (curr != null) {
            if (curr.value == element) {
                unlink(curr)
                return true
            }
            curr = curr.next
        }
        return false
    }

    override fun clear() {
        var x = head
        while (x != null) {
            val next = x.next
            x.next = null
            x.prev = null
            x = next
        }
        tail = null
        head = tail
        _size = 0
    }

    fun get(index: Int): E {
        validateElementIndex(index)
        return getNodeById(index).value
    }

    fun set(index: Int, element: E): E {
        validateElementIndex(index)
        val x = getNodeById(index)
        val oldVal = x.value
        x.value = element
        return oldVal
    }

    fun add(index: Int, element: E) {
        validatePositionIndex(index)
        if (index == _size) {
            linkTail(element)
        } else {
            linkBefore(element, getNodeById(index))
        }
    }

    fun remove(index: Int): E {
        validateElementIndex(index)
        return unlink(getNodeById(index))
    }

    fun indexOf(element: E): Int {
        var index = 0
        var x = head
        while (x != null) {
            if (element == x.value)
                return index
            index++
            x = x.next
        }
        return -1
    }

    private fun linkHead(element: E) {
        val h = head
        val newNode = Node<E>(null, element, h)
        head = newNode
        if (h == null) {
            tail = newNode
        } else {
            h.prev = newNode
        }
        _size++
    }

    private fun linkTail(element: E) {
        val t = tail
        val newNode = Node(t, element, null)
        tail = newNode
        if (t == null) {
            head = newNode
        } else {
            t.next = newNode
        }
        _size++
    }

    private fun linkBefore(element: E, nextNode: Node<E>) {
        val prevNode = nextNode.prev
        val newNode = Node(prevNode, element, nextNode)
        nextNode.prev = newNode
        if (prevNode == null) {
            head = newNode
        } else {
            prevNode.next = newNode
        }
        _size++
    }

    private fun unlinkHead() {
        head?.let {
            val next = it.next
            it.next = null
            head = next
            if (next == null) {
                tail = null
            } else {
                next.prev = null
            }
            _size--
        }
    }

    private fun unlinkTail() {
        tail?.let {
            val prev = it.prev
            it.prev = null
            tail = prev
            if (prev == null) {
                head = null
            } else {
                prev.next = null
            }
            _size--
        }
    }

    private fun unlink(curr: Node<E>): E {
        val element = curr.value
        val next = curr.next
        val prev = curr.prev

        if (prev == null) {
            head = next
        } else {
            prev.next = next
            curr.prev = null
        }

        if (next == null) {
            tail = prev
        } else {
            next.prev = prev
            curr.next = null
        }

        _size--
        return element
    }

    private fun getNodeById(index: Int): Node<E> {
        return if (index < _size shr 1) {
            var x = head
            for (i in 0 until index)
                x = x!!.next
            x!!
        } else {
            var x = tail
            for (i in _size - 1 downTo index + 1)
                x = x!!.prev
            x!!
        }
    }

    private fun validateElementIndex(index: Int) {
        if (index < 0 || index >= _size)
            throw IndexOutOfBoundsException(outOfBoundsMsg(index))
    }

    private fun validatePositionIndex(index: Int) {
        if (index in (_size + 1)..-1)
            throw IndexOutOfBoundsException(outOfBoundsMsg(index))
    }

    override fun toString(): String {
        var curr = head
        return if (curr == null) "[]"
        else {
            val sb = StringBuilder()
            sb.append('[')
            while (curr != null) {
                sb.append(curr.value)
                curr = curr.next
                if (curr?.value == null) {
                    sb.append(']')
                } else {
                    sb.append(',').append(' ')
                }
            }
            sb.toString()
        }
    }

    private fun outOfBoundsMsg(index: Int): String {
        return "Index: $index, Size: $_size"
    }

    override operator fun contains(element: E) = indexOf(element) != -1

    override fun iterator(): Iterator<E> {
        return object : Iterator<E> {
            var currentNode: MyDoublyLinkedList<E>.Node<E>? = head

            override fun hasNext(): Boolean {
                return currentNode != null
            }

            override fun next(): E {
                val value = currentNode?.value ?: throw IllegalArgumentException("Next element is null")
                if (hasNext()){
                    currentNode = currentNode?.next
                }
                return value
            }
        }
    }

    override val asList: List<E>
        get() {
            val result = mutableListOf<E>()
            val iterator = this.iterator()

            while (iterator.hasNext()){
                result.add(iterator.next())
            }

            return result
        }

    private inner class Node<E> constructor(
        var prev: Node<E>?,
        var value: E,
        var next: Node<E>?
    ) {
        fun hasNext() = next != null
    }
}
