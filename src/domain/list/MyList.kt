package domain.list

abstract class MyList<T>(elements: Collection<T> = listOf()) : Collection<T> {

    private val sorter = InsertSorter<T>()

    private var lastComparator: Comparator<T>? = null

    abstract val asList: List<T>

    init {
        addAll(elements)
    }

    /** makes the [asList] list empty*/
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
        val sortedList = sorter.sort(asList, comparator)
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

   override fun contains(element: T): Boolean{
       return this.asList.contains(element)
   }

    override fun containsAll(elements: Collection<T>): Boolean {
        return this.asList.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return asList.isEmpty()
    }

    override fun toString(): String {
        return asList.toString()
    }
}