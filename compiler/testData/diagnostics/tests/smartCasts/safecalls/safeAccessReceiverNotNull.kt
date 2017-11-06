// !WITH_NEW_INFERENCE
// !LANGUAGE: -SafeCastCheckBoundSmartCasts -BooleanElvisBoundSmartCasts
// A set of examples for
// "If the result of a safe call is not null, understand that its receiver is not null"
// and some other improvements for nullability detection

fun kt6840_1(s: String?) {
    val hash = s?.hashCode()
    if (hash != null) {
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>.length
    }
}

fun kt6840_2(s: String?) {
    if (s?.hashCode() != null) {
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>.length
    }
}

fun kt1635(s: String?) {
    s?.hashCode()!!
    <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>.hashCode()
}

fun kt2127() {
    val s: String? = ""
    if (s?.length != null) {
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>.hashCode()
    }
}

fun kt3356(s: String?): Int {
    if (s?.length != 1) return 0
    return <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>.length
}

open class SomeClass(val data: Any)

class SubClass(val extra: Any, data: Any) : SomeClass(data)

fun kt4565_1(a: SomeClass?) {
    val data = a?.data
    if (data != null) {
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>data<!><!>.hashCode()
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>a<!><!>.hashCode()
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>a<!><!>.data.hashCode()
    }
    if (a?.data != null) {
        // To be supported (?!)
        data<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>hashCode()
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>a<!><!>.hashCode()
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>a<!><!>.data.hashCode()
    }
    if (a?.data is String) {
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>a<!><!>.data.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>length<!><!>
        data.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>length<!><!>
    }
}

fun kt4565_2(a: SomeClass?) {
    // To be supported
    if (a as? SubClass != null) {
        a.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>extra<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>hashCode<!><!>()
    }
    val extra = (a as? SubClass)?.extra
    if (extra != null) {
        a.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>extra<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>hashCode<!><!>()
    }
}

class A(val y: Int)

fun kt7491_1() {
    val x: A? = A(42)
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>z<!><!> = x?.y ?: return
    <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>.y
}

fun getA(): A? = null
fun useA(a: A): Int = a.hashCode()

fun kt7491_2() {
    val a = getA()
    (a?.let { useA(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>a<!><!>) } ?: a<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>y ).toString()
}

fun String.correct() = true

fun kt8492(s: String?) {
    if (s?.correct() ?: false) {
        // To be supported
        s<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>length
    }
}

fun kt11085(prop: String?) {
    when (prop?.hashCode()) {
        1 -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>prop<!><!>.length
    }
}

class HttpExchange(val code: String)

fun kt11313(arg: HttpExchange?) {
    when (arg?.code) {
        "GET" -> handleGet(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>arg<!><!>)
        "POST" -> handlePost(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>arg<!><!>)
    }
}

fun handleGet(arg: HttpExchange) = arg

fun handlePost(arg: HttpExchange) = arg

class Wrapper {
    fun unwrap(): String? = "Something not consistent"
}

fun falsePositive(w: Wrapper) {
    if (w.unwrap() != null) {
        // Here we should NOT have smart cast
        <!NI;SMARTCAST_IMPOSSIBLE!><!SMARTCAST_IMPOSSIBLE!>w.unwrap()<!><!>.length
    }
}

class Invokable(val x: String) {
    operator fun invoke() = x
}

class InvokableProperty(val i: Invokable)

fun checkInvokable(ip: InvokableProperty?) {
    if (ip?.<!UNSAFE_IMPLICIT_INVOKE_CALL!>i<!>() == "Hello") {
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>ip<!><!>.hashCode()
    }
}