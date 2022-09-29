class BubbleSorter(private val ascendingOrder: Boolean = false):Sorter {
    companion object{
        const val name = "BubbleSorter"
    }

    /**
     * Sorts list in ascending order using bubble sort algorithm
     * @return list sorted in ascending order
     */
    override fun sort(list: List<Int>): List<Int>? {
        val result = list.toMutableList()
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

            //println("Step result: $result")
        }
        return result
    }
}