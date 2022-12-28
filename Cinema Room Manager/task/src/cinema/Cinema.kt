package cinema

fun main() {
    println("Enter the number of rows:")
    val rowsAtCinema: Int = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow: Int = readln().toInt()
    val cinema = startCinema(rowsAtCinema, seatsPerRow)
    do {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("0. Exit")
        val selectedOption: Int = readln().toInt()
        when (selectedOption) {
            1 -> printCinema(cinema)
            2 -> buyTicket(cinema)
        }
    } while (selectedOption != 0)
}

fun printCinema(cinema: MutableList<MutableList<String>>) {
    println("Cinema:")
    for (row in 0 until cinema.size) {
        println(cinema[row].joinToString(" "))
    }
    println()
}

fun startCinema(rows: Int, seats: Int): MutableList<MutableList<String>> {
    val cinema: MutableList<MutableList<String>> = mutableListOf()
    val header = mutableListOf(" ")
    for (headerColumn in 1..seats) {
        header.add(headerColumn.toString())
    }
    cinema.add(header)
    for (row in 1..rows) {
        val newRow = mutableListOf<String>(row.toString())
        for (column in 1..seats) {
            newRow.add("S")
        }
        cinema.add(newRow)
    }
    return cinema
}

fun buyTicket(cinema: MutableList<MutableList<String>>) {
    println("Enter a row number:")
    val selectedRow: Int = readln().toInt()
    println("Enter a seat number in that row:")
    val selectedSeat: Int = readln().toInt()
    val totalCinemaSeats = (cinema.size - 1)  * (cinema.first().size - 1)
    var priceTicket: Int = 10
    if (totalCinemaSeats > 60) {
        val firstHalf: Int = (cinema.size - 1) / 2
        if (selectedRow > firstHalf) {
            priceTicket = 8
        }
    }
    println("Ticket price: $$priceTicket")
    cinema[selectedRow][selectedSeat] = "B"
}