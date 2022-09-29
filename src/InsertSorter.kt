class InsertSorter: Sorter {

    companion object{
        const val name = "InsertSorter"
    }

    /**
     * Insert Method
     * sorts the given list in ascending order via swapping every element with his left neighbour until it less than it
     *@return list sorted in ascending order
     */
    override fun sort(list: List<Int>): List<Int>? {
        val result = list.toMutableList()
        result.forEachIndexed { id, value ->

            //println("Step result: $result")

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
}