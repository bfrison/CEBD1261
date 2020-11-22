// Databricks notebook source
def max(x: Int, y: Int) : Int = {
    if (x > y) {
        return x
    } else {
        return y
    }
}
def get_max(first_number: Int, second_number: Int) : String = {
    print("Please type a number: ")
    print("Please type a second number: ")
    return s"The max of $first_number and $second_number is ${max(first_number, second_number)}"
}
println(get_max(4, 5))
