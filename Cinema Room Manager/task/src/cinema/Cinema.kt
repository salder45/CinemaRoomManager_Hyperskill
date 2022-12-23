package cinema

fun main() {
    println("Enter the number of rows:")
    val rows: Int = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow: Int = readln().toInt()
    val totalSeats: Int = rows * seatsPerRow
    var income: Int = totalSeats * 10
    if (totalSeats > 60) {
        val frontHalf: Int = rows / 2
        val backHalf: Int = rows - frontHalf
        income = frontHalf * seatsPerRow * 10 + backHalf * seatsPerRow * 8
    }
    println("Total income:")
    println("$$income")
    /*
    val row: String = "S S S S S S S S"
    println("Cinema:")
    println("  1 2 3 4 5 6 7 8")
    println("1 $row")
    println("2 $row")
    println("3 $row")
    println("4 $row")
    println("5 $row")
    println("6 $row")
    println("7 $row")
     */
}