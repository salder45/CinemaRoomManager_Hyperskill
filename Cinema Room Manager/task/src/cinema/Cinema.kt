package cinema

fun main() {
    println("Enter the number of rows:")
    val rowsAtCinema: Int = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow: Int = readln().toInt()
    val cinema: MutableList<MutableList<String>> = mutableListOf()
    val header = mutableListOf(" ")
    for (headerColumn in 1..seatsPerRow) {
        header.add(headerColumn.toString())
    }
    cinema.add(header)
    for (row in 1..rowsAtCinema) {
        val newRow = mutableListOf<String>(row.toString())
        for (column in 1..seatsPerRow) {
            newRow.add("S")
        }
        cinema.add(newRow)
    }
    println("Cinema:")
    for (row in 0 until cinema.size) {
        println(cinema[row].joinToString(" "))
    }
    println("Enter a row number:")
    val selectedRow: Int = readln().toInt()
    println("Enter a seat number in that row:")
    val selectedSeat: Int = readln().toInt()
    val totalCinemaSeats = rowsAtCinema * seatsPerRow
    var priceTicket: Int = 10
    if (totalCinemaSeats > 60) {
        val firstHalf: Int = rowsAtCinema / 2
        if (selectedRow > firstHalf) {
            priceTicket = 8
        }
    }
    println("Ticket price: $$priceTicket")
    cinema[selectedRow][selectedSeat] = "B"
    println("Cinema:")
    for (row in 0 until cinema.size) {
        println(cinema[row].joinToString(" "))
    }
}