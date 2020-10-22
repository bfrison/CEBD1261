import scala.math.pow

object Exercise5 {
    def main(args: Array[String]) {
        print("Please type a number: ")
        var cube = (x:Int) => pow(x, 3).toInt
        var input = scala.io.StdIn.readLine().toInt
        println(s"The cube of $input is ${cube(input)}")
    }
}
