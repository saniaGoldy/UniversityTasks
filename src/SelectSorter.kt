import java.util.*
import kotlin.collections.ArrayList

class SelectSorter: Sorter {
    /**
     * Sorting list via select method in ascending order
     * @return list sorted in ascending order
     */
    override fun sort(list: List<Int>): List<Int> {
        val data = list.toMutableList()
        return if (list.isNotEmpty() && list.size > 1){
            val result = ArrayList<Int>()
            for (i in list.indices){
                val lowest = data.reduce { value, accumulator ->
                    if (value < accumulator) value else accumulator
                }
                result.add(lowest)
                data.remove(lowest)
            }
            result
        }else{
            list
        }
    }
}