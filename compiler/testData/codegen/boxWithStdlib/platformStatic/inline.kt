import kotlin.platform.platformStatic

object A {

    @platformStatic inline fun test(b: String = "OK") : String {
        return b
    }
}

fun box(): String {

    if (A.test() != "OK") return "fail 1"

    return "OK"
}