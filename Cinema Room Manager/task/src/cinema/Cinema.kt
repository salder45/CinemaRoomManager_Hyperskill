package cinema
const val OPEN_SEAT = "S"
const val BOUGHT_SEAT = "B"
const val PRICE_FIRST_HALF = 10
const val PRICE_LAST_HALF = 8
fun main() {
    println("Enter the number of rows:")
    val rowsAtCinema: Int = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow: Int = readln().toInt()
    val cinema = Cinema(rowsAtCinema,seatsPerRow)
    do {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        val selectedOption: Int = readln().toInt()
        when (selectedOption) {
            1 -> cinema.printCinema()
            2 -> cinema.buyTicket()
            3 -> cinema.printStatistics()
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

class Cinema (val rows: Int, val seats: Int) {
    val room: MutableList<MutableList<String>> = mutableListOf()
    var purchasedTickets: Int = 0
    var currentIncome: Int = 0
    val totalSeats: Int = rows * seats
    init {
        val header = mutableListOf(" ")
        for (headerColumn in 1..seats) {
            header.add(headerColumn.toString())
        }
        room.add(header)
        for (row in 1..rows) {
            val newRow = mutableListOf<String>(row.toString())
            for (column in 1..seats) {
                newRow.add(OPEN_SEAT)
            }
            room.add(newRow)
        }
    }

    fun printCinema() {
        println("Cinema:")
        for (row in 0 until room.size) {
            println(room[row].joinToString(" "))
        }
        println()
    }

    fun printStatistics() {
        val percentage: Double = purchasedTickets * 100.0 / (rows * seats)
        var totalIncome: Int = totalSeats * PRICE_FIRST_HALF
        if (totalSeats > 60) {
            val firstHalf = rows / 2
            val lastHalf = rows - firstHalf
            totalIncome = (firstHalf * seats * PRICE_FIRST_HALF) + (lastHalf * seats * PRICE_LAST_HALF)
        }
        println("Number of purchased tickets: $purchasedTickets")
        println("Percentage: ${"%.2f".format(percentage)}%")
        println("Current income: $$currentIncome")
        println("Total income: $$totalIncome")
    }

    fun buyTicket() {
        do {
            println("Enter a row number:")
            val selectedRow: Int = readln().toInt()
            println("Enter a seat number in that row:")
            val selectedSeat: Int = readln().toInt()
            if (selectedRow < 1 || selectedRow > rows || selectedSeat < 1|| selectedSeat > seats) {
                println("Wrong input!")
                continue
            } else if (room[selectedRow][selectedSeat] == BOUGHT_SEAT) {
                println("That ticket has already been purchased!")
                continue
            } else {
                var priceTicket: Int = PRICE_FIRST_HALF
                if (totalSeats > 60) {
                    val firstHalf: Int = rows / 2
                    if (selectedRow > firstHalf) {
                        priceTicket = PRICE_LAST_HALF
                    }
                }
                currentIncome+= priceTicket
                purchasedTickets++
                room[selectedRow][selectedSeat] = BOUGHT_SEAT
                println("Ticket price: $$priceTicket")
                break
            }
        } while (true)
    }
}