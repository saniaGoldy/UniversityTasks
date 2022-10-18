package model.journal

import swap

class InsertSorter<T> {

    /**sorts the given list via Insert Method in ascending order via swapping every element with his left neighbour until it less than it
     * @param [comparator] should return true if [v1] greater than [v2] otherwise false (invert to sort in descending order)
     *@return list sorted in ascending order
     */
    fun sort(list: List<T>, comparator: (v1: T, v2: T) -> Boolean): List<T> {
        val result = list.toMutableList()
        result.forEachIndexed { id, value ->

            //println("Step result: $result")

            if (id > 0) {
                var idCounter = id
                while (comparator.invoke(list[idCounter - 1], list[idCounter])) {
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