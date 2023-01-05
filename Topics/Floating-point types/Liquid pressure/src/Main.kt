const val GRAVITY = 9.8
fun main() {
    val density: Double = readln().toDouble()
    val height: Double = readln().toDouble()
    val pressure: Double = density * GRAVITY * height
    println(pressure)
}