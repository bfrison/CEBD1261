object Exercise4 {
    def main(args: Array[String]) {
        var fibonacci_sequence = new Array[Int](10)
        fibonacci_sequence(0) = 0
        fibonacci_sequence(1) = 1
        for (i <- 2 to 9) {
            fibonacci_sequence(i) = fibonacci_sequence(i - 2) + fibonacci_sequence(i - 1)
        }
        println(fibonacci_sequence.mkString(", "))
    }
}
