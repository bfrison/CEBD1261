import java.lang.NumberFormatException

object Exercise2 {
    def fact(number:Int) : Int = {
        var current_number = number
        var current_factorial = number
        while (current_number != 1) {
            current_number -= 1
            current_factorial *= current_number
        }
        return current_factorial
    }

    def main(args : Array[String]) {
        for (number <- args) {
            try {
                println(s"The factorial of $number is ${fact(number.toInt)}")
            }
            catch {
                case ex: NumberFormatException => {
                    println(s"$number is not an integer")
                }
            }
        }
    }
}
