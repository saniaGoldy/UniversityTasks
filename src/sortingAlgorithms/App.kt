package sortingAlgorithms

fun main() {
    val number: Int = 12345678
    println("Decimal: $number")
    println("Binary: ${number.toString(2)}")
    println("Number of set bits: ${countSetBits(number)}")
    println("Digits frequency: ${countDigitsFrequency(number)}")
}

fun countSetBits(num: Int): Int {
    var count = 0
    var n = num
    while (n != 0) {
        count += n and 1
        n = n ushr 1
    }
    return count
}

fun countDigitsFrequency(num: Int): Map<Int, Int> {
    val frequencyMap = mutableMapOf<Int, Int>().withDefault { 0 }
    var n = num
    while (n != 0) {
        val digit = n % 10
        frequencyMap[digit] = frequencyMap.getValue(digit) + 1
        n /= 10
    }
    return frequencyMap
}
