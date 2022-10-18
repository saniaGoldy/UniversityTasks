import model.journal.Journal
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val journal = Journal(scanner)
    printStudents(journal)

    var input = ""
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
        if (input.matches(Regex("[0123]"))) {
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