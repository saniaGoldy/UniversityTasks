package domain.model

import domain.list.MyArrayList
import domain.list.MyLinkedList
import runUntilSucceeds
import utils.sampleStudents
import java.util.*

object JournalFactory {

    fun getSampleJournal(): Journal {
        val students = MyArrayList<Student>()

        students.addAll(
            sampleStudents
        )

        return Journal(students)
    }

    fun getJournalFromUserInput(scanner: Scanner): Journal {
        val students = MyLinkedList<Student>()
        students.addAll(readStudents(scanner))
        return Journal(students)
    }

    private fun readStudents(scanner: Scanner): List<Student> {
        val students = mutableListOf<Student>()
        var i = 0
        while (i < STUDENTS_AMOUNT) {
            val student = runUntilSucceeds(i + 1) { readStudent(it, scanner) }
            if (students.contains(student)) {
                println("\nThis student already exists\n")
            } else {
                students.add(student)
                i++
            }
        }
        return students
    }

    private fun readStudent(studentId: Int, scanner: Scanner): Student {

        println("Input student $studentId sheetId: ")
        val sheetId = scanner.nextLine().toInt()

        println("Input student $studentId surname: ")
        val surname = scanner.nextLine()

        val birthDate = runUntilSucceeds(studentId) { id -> readDate(id, scanner) }

        val grades = runUntilSucceeds(studentId) { id -> readGrades(id, scanner) }

        return Student(sheetId, surname, birthDate, grades)
    }

    private fun readDate(studentId: Int, scanner: Scanner): MyDate {
        println("Input $studentId student birth date: ")

        println("Input date: ")
        val date = scanner.nextLine().toInt()

        println("Input month: ")
        val month = scanner.nextLine().toInt()

        println("Input year: ")
        val year = scanner.nextLine().toInt()

        return MyDate(Date(year, month, date))
    }

    private fun readGrades(studentId: Int, scanner: Scanner): MutableMap<Subject, Int> {
        val grades = mutableMapOf<Subject, Int>()
        println("Input student $studentId grades")
        Subject.values().forEach {
            println("Input grade for $it")
            val grade = scanner.nextLine().toInt()
            grades[it] = grade
        }
        return grades
    }

}