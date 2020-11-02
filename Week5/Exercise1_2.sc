object Exercise1_2 {
    var numbers = 1 to 9
    var numbers2 = numbers.filter((x: Int) => x % 2 != 0)
    var cube = (x: Int) => x * x * x
    var numbers3 = numbers2.map(cube)
}
