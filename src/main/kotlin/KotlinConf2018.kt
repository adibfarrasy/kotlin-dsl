import java.time.LocalDateTime

fun main() {
    // infix functions
//    val car = Car()
//    car drive 10

    // extension functions
//    val greet = "Hello"
//    println(greet.shout())

    // last lambda outside of argument parenthesis
//    process(2, { e -> println(e) })
//    process(2) { e -> println(e) }

    // implicit receivers
//    call { name -> println("${this.uppercase()} $name") }

    val ago = Tense.AGO
    val from_now = Tense.FROM_NOW

    2 days ago
    3 days from_now

    "planning" meeting {
        start at 3..15
    }

    val robotA = Robot("Robot A")

    robotA operate {
        it turns left
        it turns right
        it runs fast
    }
}

class Car {
    infix fun drive(dist: Int) {
        println("driving for $dist m...")
    }
}

fun String.shout() = this.uppercase()

fun process(n: Int, func: (n: Int) -> Unit) {
    func(n * 2)
}

fun call(greet: String.(String) -> Unit) = "Hello".greet("Jane")

enum class Tense {
    AGO,
    FROM_NOW
}

infix fun Int.days(tense: Tense) {
    when (tense) {
        Tense.AGO -> println(LocalDateTime.now().minusDays(this.toLong()))
        Tense.FROM_NOW -> println(LocalDateTime.now().plusDays(this.toLong()))
    }
}

data class Meeting(val name: String) {
    val start = this

    infix fun at(time: IntRange) {
        println("$name starts at $time")
    }
}

infix fun String.meeting(block: Meeting.() -> Unit) {
    Meeting(this).block()
}

data class Robot(val name: String) {
    val left = "left"
    val right = "right"
    val fast = "fast"

    infix fun turns(direction: String) = println("$name turns $direction")

    infix fun runs(speed: String) = println("$name runs $speed")
}

infix fun Robot.operate(block: Robot.(Robot) -> Unit) {
    this.block(this)
}

