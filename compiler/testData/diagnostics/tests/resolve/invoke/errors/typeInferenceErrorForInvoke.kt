// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_PARAMETER

class A<T>

operator fun <T> T.invoke(a: A<T>) {}

fun foo(s: String, ai: A<Int>) {
    1(ai)

    <!TYPE_INFERENCE_CONFLICTING_SUBSTITUTIONS!>s<!>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>ai<!><!>)

    <!NI;TYPE_INFERENCE_CONFLICTING_SUBSTITUTIONS!><!TYPE_INFERENCE_CONFLICTING_SUBSTITUTIONS!>""<!><!>(ai)
}
