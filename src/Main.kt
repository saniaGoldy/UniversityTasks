import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
    val data = getListOfRandomNumbers()
    println("Initial data: $data")

    measureSorter(SelectSorter(), data)
    measureSorter(BubbleSorter(), data)
    measureSorter(ShakerSorter(), data)
    measureSorter(InsertSorter(), data)
}

private fun measureSorter(sorter: Sorter, data: MutableList<Int>) {
    measureTimeMillis {
        println("\n Measuring ${sorter::class.java.name}")
        val sortedList = sorter.sort(data)
        println("Sorted list: [${sortedList?.get(0)},${sortedList?.get(1)}...${sortedList?.get(sortedList.lastIndex)}]")
    }.let {
        println("\n Execution time: $it ms")
    }
}


