import domain.BinaryTreeSorter
import domain.MergeSorter
import domain.QuickSorter
import domain.Sorter
import kotlin.system.measureTimeMillis

fun main() {
    val data = getListOfRandomNumbers()
    println("Initial data: $data")

    while (true) {
        when (chooseSorter()) {
            "1" -> measureSorter(BinaryTreeSorter(), data)
            "2" -> measureSorter(QuickSorter(), data)
            "3" -> measureSorter(MergeSorter(), data)
            else -> break
        }
    }
}

private fun chooseSorter(): String? {
    println("Choose sorting method( 1-for binary search tree, 2-for quick sort, 3-for merge sort, anything else to exit)")
    return readLine()
}

private fun measureSorter(sorter: Sorter, data: MutableList<Int>) =
    measureTimeMillis {
        println("\n Measuring ${sorter::class.java.name}")
        val sortedList = sorter.sort(data)
        println("Sorted list: [${sortedList?.get(0)},${sortedList?.get(1)}...${sortedList?.get(sortedList.lastIndex)}]")
    }.let {
        println("\n Execution time: $it ms")
    }
