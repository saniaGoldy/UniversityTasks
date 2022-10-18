package model.journal

import model.MyDate
import model.Student
import model.Subject
import runUntilSucceeds
import java.util.*

const val STUDENTS_AMOUNT = 6

class Journal(private val scanner: Scanner) {

    private var _students = mutableListOf<Student>()
    val students: List<Student> get() = _students

    private val sorter = InsertSorter<Student>()

    init {
        readStudents()
    }

    private fun readStudents() {
        var i = 0
        while (i < STUDENTS_AMOUNT) {
            val student = runUntilSucceeds(i + 1) { readStudent(it) }
            if (students.contains(student)) {
                println("\nThis student already exists\n")
            } else {
                _students.add(student)
                i++
            }
        }
    }

    private fun readStudent(studentId: Int): Student {

        println("Input student $studentId sheetId: ")
        val sheetId = scanner.nextLine().toInt()

        println("Input student $studentId surname: ")
        val surname = scanner.nextLine()

        val birthDate = runUntilSucceeds(studentId) { id -> readDate(id) }

        val grades = runUntilSucceeds(studentId) { id -> readGrades(id) }

        return Student(sheetId, surname, birthDate, grades)
    }

    private fun readDate(studentId: Int): MyDate {
        println("Input $studentId student birth date: ")

        println("Input date: ")
        val date = scanner.nextLine().toInt()

        println("Input month: ")
        val month = scanner.nextLine().toInt()

        println("Input year: ")
        val year = scanner.nextLine().toInt()

        return MyDate(Date(year, month, date))
    }

    private fun readGrades(studentId: Int): MutableMap<Subject, Int> {
        val grades = mutableMapOf<Subject, Int>()
        println("Input student $studentId grades")
        Subject.values().forEach {
            println("Input grade for $it")
            val grade = scanner.nextLine().toInt()
            grades[it] = grade
        }
        return grades
    }


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
        _students = sorter.sort(students) { student1, student2 ->
            student1.birthDate.compare(student2.birthDate) == 1
        } as MutableList<Student>
    }

    private fun sortByRating() {
        _students = sorter.sort(students) { student1, student2 ->
            student1.rating > student2.rating
        } as MutableList<Student>
    }

    private fun sortBySurname() {
        _students = sorter.sort(students) { student1, student2 ->
            student1.surname > student2.surname
        } as MutableList<Student>
    }
}