package sortingAlgorithms

import kotlin.random.Random

private const val DATA_SIZE = 10

fun main() {
    val rawData = getRowOfRandomNumbers()

    println("Initial data: $rawData")
    println("\nInsert Method:")
    println("\nSorted List: ${rawData.swapSort()}\n")

    println("Initial data: $rawData")
    println("\nSelect Method:")
    println("\nSorted List: ${rawData.insertSort()}\n")

    println("Initial data: $rawData")
    println("\nBubble Sort Method:")
    println("\nSorted List: ${rawData.bubbleSort()}")


    val matrixData = mutableListOf<List<Int>>()
    repeat(DATA_SIZE){
        matrixData.add(getRowOfRandomNumbers())
    }

    println("Unsorted Matrix:")
    matrixData.forEach { println(it) }


    matrixData.map { it.bubbleSort(false) }.apply {
        println("\nSortedMatrix:")
    }.forEach { println(it) }
}

private fun getRowOfRandomNumbers(): MutableList<Int> {
    val rawData = mutableListOf<Int>()
    repeat(DATA_SIZE) {
        rawData.add(Random.nextInt() % 10)
    }
    return rawData
}

fun MutableList<Int>.swap(firstId: Int, secondId: Int) {
    val firstValue = this[firstId]
    this[firstId] = this[secondId]
    this[secondId] = firstValue
}

/**
 * Select method
 * sorts the given list in ascending order
 * swapping lowest with first then calls itself on sub list from second element till last
 * @return list sorted in ascending order
 */
fun List<Int>.swapSort(): List<Int>? {

    if (this.isNotEmpty() && this.size > 1) {
        val lowest = this.reduce { value, accumulator ->
            if (value < accumulator) value else accumulator
        }

        val stepResult = this.toMutableList()
        stepResult.swap(0, this.indexOf(lowest))
        println("Step Result: $stepResult")

        stepResult.subList(1, size).swapSort().let { resultList ->
            return if (resultList != null) {
                listOf(lowest) + resultList
            } else {
                listOf(lowest)
            }
        }
    }
    return null
}

/**
 * Insert Method
 * sorts the given list in ascending order via swapping every element with his left neighbour until it less than it
 *@return list sorted in ascending order
 */
fun List<Int>.insertSort(): List<Int> {
    val result = this.toMutableList()

    result.forEachIndexed { id, value ->

        println("Step result: $result")

        if (id > 0) {
            var idCounter = id
            while (result[idCounter - 1] > value) {
                result.swap(idCounter - 1, idCounter)
                if (idCounter == 1)
                    break
                idCounter--
            }
        }
    }

    return result
}

/**
 * Sorts list in ascending order using bubble sort algorithm
 * @return list sorted in ascending order
 */
fun List<Int>.bubbleSort(ascendingOrder: Boolean = true): List<Int> {
    val result = this.toMutableList()
    for (i in 1 until result.lastIndex) {
        for (j in result.lastIndex downTo i){
            if (ascendingOrder){
                if (result[j] > result[j-1])
                    result.swap(j-1, j)
            }else
                if (result[j] < result[j-1]) {
                    result.swap(j-1, j)
                }
        }

        println("Step result: $result")
    }
    return result
}

