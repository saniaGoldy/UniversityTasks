package domain.list

abstract class MyList<T> {

    private val sorter = InsertSorter<T>()

    abstract val elements: List<T>

    /** makes the [elements] list empty*/
    abstract fun clear()

    /** Adds an element at the back of the list*/
    abstract fun add(element: T)

    /** Prints the elements in standard out*/
    open fun print(){
        println("List:")
        println(this)
    }

    /** Adds elements at the back of the list*/
    open fun addAll(vararg elements: T){
        elements.forEach { element -> add(element) }
    }

    /** Adds elements at the back of the list*/
    open fun addAll(elements: List<T>){
        elements.forEach { element -> add(element) }
    }

    /** Clears the list and adds all [elements] */
    open fun reset(elements: List<T>){
        clear()
        addAll(elements)
    }

    open fun sort(comparator: Comparator<T>){
        val sortedList = sorter.sort(elements, comparator)
        reset(sortedList)
    }

    open fun isEmpty():Boolean{
        return elements.isEmpty()
    }

    override fun toString(): String {
        return elements.toString()
    }
}