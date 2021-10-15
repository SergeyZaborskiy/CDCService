import java.math.BigDecimal

fun main(args: Array<String>) {

    coordinatesToBigDecimal("S1738.50")
    }

fun coordinatesToBigDecimal(coordinate: String?) {
    val direction: String? = coordinate?.substring(0, 1)
    var directionInt = 1
    var hours: Int? = 0
    var minutes: Double? = 0.0

    if (direction == "S" || direction == "W") {
        directionInt = -1
    }

    if (direction == "W" || direction == "E") {
        hours = coordinate?.substring(1, 4)?.toInt()
        minutes = (coordinate?.substring(4)?.toDouble())?.div(60)
    } else {
        hours = coordinate?.substring(1, 3)?.toInt()
        minutes = (coordinate?.substring(3)?.toDouble())?.div(60)
    }


    println((hours?.plus(minutes!!))?.times(directionInt)?.toBigDecimal())
}