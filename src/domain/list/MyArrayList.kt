package domain.list

class MyArrayList<T>() : MyList<T>() {
    private var _elements = mutableListOf<T>()

    override val elements: List<T>
        get() = _elements

    override fun clear() = _elements.clear()

    fun delete(position: Int) {
        _elements =
            (_elements.subList(0, position) + _elements.subList(position + 1, _elements.size))
                    as MutableList<T>
    }

    fun delete(element: T) {
        _elements.forEachIndexed { id, value ->
            if (value == element){
                return delete(id)
            }
        }
    }

    fun insert(element: T, position: Int) {
        _elements =
            (_elements.subList(0, position) + listOf(element) + _elements.subList(position + 1, _elements.size))
                    as MutableList<T>
    }

    override fun add(element: T) {
        _elements.add(element)
    }
}