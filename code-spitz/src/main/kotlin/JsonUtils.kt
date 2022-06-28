import kotlin.reflect.KProperty

/**
 * Created by marathoner on 2022/06/24
 */
fun stringify(value: Any?): String = when (value) {
    null -> "null"
    is String -> jsonString(value)
    is Boolean, is Number -> "$value"
    is List<*> -> jsonList(value)
    else -> jsonObject(value)
}

private fun <T : Any> jsonObject(target: T): String {
    val builder = StringBuilder()
    return target::class.members
        .filterIsInstance<KProperty<*>>()
        .joinTo(builder, ",", "{", "}") {
            "${stringify(it.name)}:${stringify(it.getter.call(target))}"
        }.toString()
}

private fun jsonList(target: List<*>): String {
    val builder = StringBuilder()
    return target.joinTo(builder, ",", "[", "]", transform = ::stringify).toString()

}

private fun jsonString(v: String): String = """"${v.replace("\"", "\\\"")}""""

class Json0(val a: Int, val b: String)
