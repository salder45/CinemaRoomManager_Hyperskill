fun main() {
    // Do not touch code below
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    // write your code here
    val firstRow = inputList[0]
    val lastRow = inputList[inputList.size - 1]
    println("${firstRow[0]} ${firstRow[firstRow.size - 1]}")
    // println("${inputList.first().first()} ${inputList.first().last()}")
    println("${lastRow[0]} ${lastRow[lastRow.size - 1]}")
    // println("${inputList.last().first()} ${inputList.last().last()}")

}