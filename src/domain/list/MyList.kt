package domain.list

abstract class MyList<T>(elements: Collection<T> = listOf()) : Collection<T> {

    private val sorter = InsertSorter<T>()

    private var lastComparator: Comparator<T>? = null

    abstract val toList: List<T>

    init {
        addAll(elements)
    }

    /** makes the [toList] list empty*/
    abstract fun clear()

    /** Adds an element at the back of the list*/
    abstract fun add(element: T)

    /** Prints the elements in standard out*/
    open fun print() {
        println("List:")
        println(this)
    }

    /** Adds elements at the back of the list*/
    open fun addAll(vararg elements: T) {
        elements.forEach { element -> add(element) }
    }

    /** Adds elements at the back of the list*/
    fun addAll(elements: Collection<T>) {
        elements.forEach { element -> add(element) }
    }

    /** Clears the list and adds all [elements] */
    open fun reset(elements: List<T>) {
        clear()
        addAll(elements)
    }

    open fun sort(comparator: Comparator<T>  /* = (v1: T, v2: T) -> kotlin.Boolean */) {
        lastComparator = comparator
        val sortedList = sorter.sort(toList, comparator)
        reset(sortedList)
    }

    /** Merges [elements] in list using given [comparator] or last used comparator by default.
     * Adds [elements] in back of the list if [comparator] is not specified and list was never sorted before
     * */
    open fun mergeSorting(
        elements: Collection<T>,
        comparator: Comparator<T>? /* = (v1: T, v2: T) -> kotlin.Boolean */ = lastComparator
    ) {
        addAll(elements)
        comparator?.let { comp -> sort(comp) }
    }

    override fun isEmpty(): Boolean {
        return toList.isEmpty()
    }

    override fun toString(): String {
        return toList.toString()
    }


}