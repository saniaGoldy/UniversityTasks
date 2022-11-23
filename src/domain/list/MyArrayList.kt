package domain.list

class MyArrayList<T>(elements: Collection<T> = listOf()) : MyList<T>() {
    private var _elements = mutableListOf<T>()

    init {
        addAll(elements)
    }

    override val asList: List<T>
        get() = _elements

    override fun clear() = _elements.clear()

    fun delete(position: Int) {
        if (position in _elements.indices) {
            _elements =
                (_elements.subList(0, position) + _elements.subList(position + 1, _elements.size))
                        as MutableList<T>
        }
    }

    fun delete(element: T) {
        _elements.forEachIndexed { id, value ->
            if (value == element) {
                return delete(id)
            }
        }
    }

    fun insert(element: T, position: Int) {
        if (position in _elements.indices) {
            _elements =
                (_elements.subList(0, position) + listOf(element) + _elements.subList(position, _elements.size))
                        as MutableList<T>
        }
    }

    override fun add(element: T) {
        _elements.add(element)
    }

    override val size: Int
        get() = _elements.size

    override fun contains(element: T): Boolean = asList.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean = elements.containsAll(elements)

    override fun iterator(): Iterator<T> = _elements.iterator()

}