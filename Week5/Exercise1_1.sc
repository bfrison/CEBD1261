object Exercise1_1 {

    def greet1(name: String): String = {
        return s"Hello $name, How are you doing?"
    }

    def greet2(name: String): String = {
        return s"Hello $name, How was your day?"
    }

    def frame(name: String, greeting: (String) => String) = {
        println(greeting(name))
    }
    frame("Alice", greet1)
    frame("Nick", greet2)
}
