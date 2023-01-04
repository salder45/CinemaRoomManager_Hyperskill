fun convertStringToDouble(input: String): Double {
    var value: Double = -1.0
    try {
        value = input.toDouble()
    } catch (e: Exception) {
        value = 0.0
    }
    return value
}