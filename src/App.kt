import java.util.*
import kotlin.random.Random

fun main() {
    val scanner = Scanner(System.`in`)

    //Кількість рядків першої матриці
    val n = scanner.nextInt()
    val m = scanner.nextInt()

    //Кількість стовбичків другої матриці
    val k = scanner.nextInt()

    //Створення та ініціалізація першої матриці
    println("First Matrix")
    val firstMatrix = Array(n) { getRowOfRandomNumbers(m) }
    firstMatrix.forEach { println(it) }

    //Створення та ініціалізація другої матриці
    println("Second Matrix")
    val secondMatrix = Array(m) { getRowOfRandomNumbers(k) }
    secondMatrix.forEach { println(it) }


    //Обрахування результуючої матриці
    val resultMatrix = Array(n) { IntArray(k) }
    for (i in 0 until n) {
        for (u in 0 until k) {
            for (j in 0 until m) {
                resultMatrix[i][u] += firstMatrix[i][j] * secondMatrix[j][u]
            }
        }
    }

    //Виведення результатів роботи
    resultMatrix.forEach { row ->
        println()
        row.forEach { element -> print("$element ") }
    }
}

private fun getRowOfRandomNumbers(rowSize: Int): MutableList<Int> {
    val rawData = mutableListOf<Int>()
    repeat(rowSize) {
        rawData.add(Random.nextInt() % 10)
    }
    return rawData
}
