object Exercise2 {
    def main(args: Array[String]) {
        val numbers = 1 to 45
        println(s"The sum of all multiples of 4 is ${
            numbers
            .filter((x: Int) => x % 4 ==0)
            .sum
        }")
        println(s"The sum of all multiples of 3 smaller than 20 is ${
            numbers
            .filter((x: Int) => x % 3 == 0 & x < 20)
            .map((x: Int) => x * x)
            .sum
        }")
    }
}
