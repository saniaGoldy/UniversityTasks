package model

data class Student(
    val sheetId: Int,
    val surname: String,
    val birthDate: MyDate,
    val grades: MutableMap<Subject, Int> = mutableMapOf()
) {

    val rating get() = grades.values.average()

    override fun equals(other: Any?): Boolean {
        return other?.let {
            if (it is Student) {
                it.sheetId == this.sheetId
            } else
                false
        } ?: false
    }

    override fun hashCode(): Int {
        var result = sheetId
        result *= 31
        return result
    }
}
