import kotlin.math.pow

class Matrix(val elements: Array<Array<Int>>) {

    fun getInverseMatrix(): Matrix {
        val size = elements.size
        val cofactors = Array(size) { Array(size) { 0 } }

        for (i in 0 until size) {
            for (j in 0 until size) {
                val minor = getMinorMatrix(i, j)
                val sign = (-1).toDouble().pow(i + j).toInt()
                cofactors[j][i] = sign * minor.getDeterminant()
            }
        }

        val determinant = getDeterminant()
        val inverseElements = Array(size) { Array(size) { 0 } }

        for (i in 0 until size) {
            for (j in 0 until size) {
                inverseElements[i][j] = cofactors[i][j] / determinant
            }
        }

        return Matrix(inverseElements)
    }

    fun getDeterminant(): Int {
        val size = elements.size

        if (size == 1) {
            return elements[0][0]
        }

        var determinant = 0

        for (i in 0 until size) {
            val minor = getMinorMatrix(0, i)
            val sign = (-1).toDouble().pow(i).toInt()
            determinant += sign * elements[0][i] * minor.getDeterminant()
        }

        return determinant
    }

    private fun getMinorMatrix(row: Int, column: Int): Matrix {
        val size = elements.size
        val minorElements = Array(size - 1) { Array(size - 1) { 0 } }
        var minorRow = 0

        for (i in 0 until size) {
            if (i == row) continue
            var minorColumn = 0

            for (j in 0 until size) {
                if (j == column) continue
                minorElements[minorRow][minorColumn] = elements[i][j]
                minorColumn++
            }

            minorRow++
        }

        return Matrix(minorElements)
    }

    fun multiplyByInverse(): Matrix {
        val inverseMatrix = getInverseMatrix()
        return multiplyByMatrix(inverseMatrix)
    }

    private fun multiplyByMatrix(matrix: Matrix): Matrix {
        val size = elements.size
        val resultElements = Array(size) { Array(size) { 0 } }

        for (i in 0 until size) {
            for (j in 0 until size) {
                for (k in 0 until size) {
                    resultElements[i][j] += elements[i][k] * matrix.elements[k][j]
                }
            }
        }

        return Matrix(resultElements)
    }
}

fun main() {
    val elements = arrayOf(
        arrayOf(415, 747, 186, 663, 415, 709, 954, 670, 993, 718),
        arrayOf(969, 644, 835, 470, 876, 4, 670, 997, 651, 872),
        arrayOf(77, 10, 340, 459, 79, 580, 437, 195, 111, 828),
        arrayOf(628, 160, 433, 231, 303, 701, 297, 195, 246, 336),
        arrayOf(695, 600, 156, 434, 787, 724, 874, 855, 256, 558),
        arrayOf(665, 125, 369, 480, 11, 749, 105, 514, 314, 694),
        arrayOf(324, 498, 66, 445, 973, 418, 647, 314, 561, 129),
        arrayOf(947, 181, 851, 580, 714, 599, 559, 87, 45, 633),
        arrayOf(421, 625, 801, 861, 200, 415, 194, 337, 165, 396),
        arrayOf(341, 425, 377, 862, 197, 25, 371, 834, 128, 431)
    )

    val matrix = Matrix(elements)

    val inverseMatrix = matrix.getInverseMatrix()
    println("Inverse Matrix:")
    inverseMatrix.printMatrix()

    val determinant = matrix.getDeterminant()
    println("Determinant: $determinant")

    val multipliedMatrix = matrix.multiplyByInverse()
    println("Multiplied Matrix:")
    multipliedMatrix.printMatrix()
}

fun Matrix.printMatrix() {
    for (row in elements) {
        for (element in row) {
            print("$element ")
        }
        println()
    }
}