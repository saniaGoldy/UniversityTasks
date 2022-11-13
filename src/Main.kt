import domain.model.Journal
import domain.model.JournalFactory
import java.util.*

/**
 * 0 to use previous method
 *
 * 1 to sort by surname
 *
 * 2 to sort by birthDate
 *
 * 3 to sort by rating
 */
private const val SortingOptionsRegex = "[0123]"

fun main() {
    val scanner = Scanner(System.`in`)

    val journal = JournalFactory.getSampleJournal()

    printStudents(journal)

    var input: String
    while (true) {
        println(
            "Input 0 to use previous method\n" +
                    "     1 to sort by surname\n" +
                    "     2 to sort by birthDate\n" +
                    "     3 to sort by rating\n" +
                    "     'stop' to stop the app"
        )
        input = scanner.nextLine()

        if (input == "stop")
            break
        if (input.matches(Regex(SortingOptionsRegex))) {
            journal.sort(input.toInt())
            printStudents(journal)
        } else {
            println("Invalid input, please try again")
        }
    }

}

private fun printStudents(journal: Journal) {
    println("\nStudents:")
    journal.students.forEach {
        println(it)
    }
}