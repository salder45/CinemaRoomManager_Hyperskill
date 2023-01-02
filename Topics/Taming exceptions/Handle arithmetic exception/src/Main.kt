fun main() {
    val firstNumber: Int = readln().toInt()
    val secondNumber: Int = readln().toInt()
    if (secondNumber == 0) {
        println("Division by zero, please fix the second argument!")
    } else {
        val result: Int = firstNumber / secondNumber
        println(result)
    }
}