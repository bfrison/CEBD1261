object Exercise3 {
    def max(x: Int, y: Int) : Int = {
        if (x > y) {
            return x
        } else {
            return y
        }
    }
    def get_max() : String = {
        print("Please type a number: ")
        var first_number = scala.io.StdIn.readLine().toInt
        print("Please type a second number: ")
        var second_number = scala.io.StdIn.readLine().toInt
        return s"The max of $first_number and $second_number is ${max(first_number, second_number)}"
    }
    def main(args: Array[String]) {
        println(get_max())
    }
}
