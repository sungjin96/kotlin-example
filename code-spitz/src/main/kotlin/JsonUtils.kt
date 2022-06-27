import kotlin.reflect.KProperty

/**
 * Created by marathoner on 2022/06/24
 */
fun <T : Any> stringify(target: T): String {
    val builder = StringBuilder()
    builder.append("{")
    target::class.members.filterIsInstance<KProperty<*>>().forEach {
        builder.append(it.name, ":")
        val value = it.getter.call(target)
        builder.append(value, ',')
    }
    builder.append("}")
    return "$builder"
}

class Json0(val a:Int, val b: String)
