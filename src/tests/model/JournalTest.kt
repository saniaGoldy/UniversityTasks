package tests.model

import domain.model.Journal
import domain.model.JournalFactory
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import utils.sampleStudents

internal class JournalTest {

    lateinit var journal: Journal

    @BeforeEach
    fun setup() {
        journal = JournalFactory.getSampleJournal()
    }

    @Test
    fun sortByLastSortMethodWhenThereIsNoLastMethod() {
        journal.sort(0)
        assert(journal.students == sampleStudents)
    }

    @Test
    fun sortByLastSortMethod() {
        journal.sort(1)
        val sortedStudents = journal.students
        journal.sort(0)

        assert(journal.students == sortedStudents)
    }

    @Test
    fun sortBySurname() {
        journal.sort(1)

        assert(
            journal.students == listOf(
                sampleStudents[2],
                sampleStudents[1],
                sampleStudents[0]
            )
        )
    }

    @Test
    fun sortByBirthDate() {
        journal.sort(2)

        assert(
            journal.students == listOf(
                sampleStudents[0],
                sampleStudents[2],
                sampleStudents[1]
            )
        )
    }

    @Test
    fun sortByRating() {
        journal.sort(3)

        assert(
            journal.students == listOf(
                sampleStudents[1],
                sampleStudents[0],
                sampleStudents[2]
            )
        )
    }
}