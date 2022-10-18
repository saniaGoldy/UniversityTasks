package model

import java.util.*

data class MyDate(val date: Date) {
    val day = date.date
    val month = date.month
    val year = date.year

    /**
     * @return 1 if specified [dateToCompareWith] is before [date]
     * 0 if specified [dateToCompareWith] is equal to [date]
     * -1 if specified [dateToCompareWith] is after [date]
     */
    fun compare(dateToCompareWith: MyDate): Int {
        return if (dateToCompareWith.date.before(this.date)) {
            1
        } else if (dateToCompareWith == this) {
            0
        } else
            -1
    }
}
