fun main() {
    val companies: Int = readln().toInt()
    val income: MutableList<Int> = mutableListOf()
    val taxesPercentage: MutableList<Int> = mutableListOf()
    for (company in 1..companies) {
        income.add(readln().toInt())
    }
    for (company in 1..companies) {
        taxesPercentage.add(readln().toInt())
    }
    var maxTax: Double = 0.0
    var maxIndex: Int = -1
    for (index in 1..companies) {
        val tax: Double = income[index - 1] * (taxesPercentage[index - 1].toDouble() / 100)
        if (maxTax < tax) {
            maxTax = tax
            maxIndex = index
        }
    }
    println(maxIndex)
}