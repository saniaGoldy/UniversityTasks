import kotlin.properties.Delegates

class ShakerSorter: Sorter{

    companion object{
        const val name = "ShakerSorter"
    }

    private var borderShift by Delegates.notNull<Int>()

    /**Optimized [BubbleSorter] realization */
    override fun sort(list: List<Int>): MutableList<Int> {
        val result = list.toMutableList()
        var leftBorder: Int
        var rightBorder = list.size - 1

        borderShift = rightBorder

        do {
            for (j in rightBorder downTo 1) {
                result.swapIfPreviousBiggerThanCurrent(j)
            }

            leftBorder = borderShift + 1

            for (j in 1..rightBorder) {
                result.swapIfPreviousBiggerThanCurrent(j)
            }

            rightBorder = borderShift - 1

        } while (leftBorder < rightBorder)

        return result
    }



    private fun MutableList<Int>.swapIfPreviousBiggerThanCurrent(currentId: Int){
        if (this[currentId - 1] > this[currentId]) {
            this.swap(currentId - 1, currentId)
            //println("Step: swap id[${currentId-1}] with id[$currentId] \n$this")
            borderShift = currentId
        }
    }
}