package domain

class MergeSorter : Sorter {
    override fun sort(list: List<Int>): List<Int> {
        if (list.isEmpty()) return listOf()
        val data = list.toIntArray()

        mergeSort(data, 0, list.lastIndex)
        return data.toList()
    }

    private fun mergeSort(a: IntArray, beg: Int, end: Int) {
        if (beg < end) {
            val mid = (beg + end) / 2
            mergeSort(a, beg, mid)
            mergeSort(a, mid + 1, end)
            merge(a, beg, mid, end)
        }
    }

    private fun merge(a: IntArray, beg: Int, mid: Int, end: Int) {
        val n1 = mid - beg + 1
        val n2 = end - mid
        val leftArray = IntArray(n1)
        val rightArray = IntArray(n2) //temporary arrays

        /* copy data to temp arrays */
        var i: Int = 0
        while (i < n1) {
            leftArray[i] = a[beg + i]
            i++
        }
        var j: Int = 0
        while (j < n2) {
            rightArray[j] = a[mid + 1 + j]
            j++
        }
        i = 0 /* initial index of first sub-array */
        j = 0 /* initial index of second sub-array */
        var k: Int = beg /* initial index of merged sub-array */
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                a[k] = leftArray[i]
                i++
            } else {
                a[k] = rightArray[j]
                j++
            }
            k++
        }
        while (i < n1) {
            a[k] = leftArray[i]
            i++
            k++
        }
        while (j < n2) {
            a[k] = rightArray[j]
            j++
            k++
        }
    }

}