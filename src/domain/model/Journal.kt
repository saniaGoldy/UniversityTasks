package domain.model

import domain.list.MyList

const val STUDENTS_AMOUNT = 6

class Journal(listImpl: MyList<Student>) {

    private val _students = listImpl
    val students: List<Student> get() = _students.toList

    private var lastSortMethodId: Int? = null

    /**
     * @param [sortMethodCode]
     * 0 to use previous method
     * 1 to sort by [Student.surname]
     * 2 to sort by [Student.birthDate]
     * 3 to sort by [Student.rating]
     */
    fun sort(sortMethodCode: Int?): Boolean {
        when (sortMethodCode) {
            0 -> {
                return sort(lastSortMethodId)
            }
            1 -> {
                lastSortMethodId = 1
                sortBySurname()
            }
            2 -> {
                lastSortMethodId = 2
                sortByDate()
            }
            3 -> {
                lastSortMethodId = 3
                sortByRating()
            }
            null -> {
                return true
            }
            else -> {
                return false
            }
        }
        return true
    }

    private fun sortByDate() {
        _students.sort { student1, student2 ->
            student1.birthDate.compare(student2.birthDate) == 1
        }
    }

    private fun sortByRating() {
        _students.sort { student1, student2 ->
            student1.rating > student2.rating
        }
    }

    private fun sortBySurname() {
        _students.sort { student1, student2 ->
            student1.surname > student2.surname
        }
    }
}