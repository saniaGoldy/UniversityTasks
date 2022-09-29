import kotlin.random.Random

private const val MY_LIST_ID = 13
private const val DATA_SIZE = 10_000L

fun getListOfRandomNumbers(): MutableList<Int> {
    val rawData = mutableListOf<Int>()
    for (i in 0 until (DATA_SIZE * MY_LIST_ID)) {
        rawData.add(Random.nextInt())
    }
    return rawData
}

fun MutableList<Int>.swap(firstId: Int, secondId: Int) {
    val firstValue = this[firstId]
    this[firstId] = this[secondId]
    this[secondId] = firstValue
}