package domain

import swap

class QuickSorter : Sorter {

    override fun sort(list: List<Int>): List<Int> {
        val values = list.toMutableList()
        var leftBorder = 0
        var rightBorder = values.lastIndex
        val middleElement = list[values.lastIndex / 2]

        while (leftBorder < rightBorder) {
            while (values[leftBorder] < middleElement)
                leftBorder++
            while (values[rightBorder] > middleElement)
                rightBorder--
            if (leftBorder < rightBorder) {
                values.swap(leftBorder, rightBorder)
                leftBorder++
                rightBorder--
            }
        }

        val firstMiddleElementId = values.indexOfFirst { it == middleElement }
        val leftValues =
            if (firstMiddleElementId > 1)
                sort(values.subList(0, firstMiddleElementId))
            else
                values.subList(0, firstMiddleElementId)

        val lastMiddleElementId = values.lastIndexOf(middleElement)
        val rightValues =
            if (lastMiddleElementId < values.lastIndex - 1)
                sort(values.subList(lastMiddleElementId + 1, values.size))
            else
                values.subList(lastMiddleElementId + 1, values.size)

        return leftValues.plus(values.subList(firstMiddleElementId, lastMiddleElementId + 1)).plus(rightValues)
    }
}