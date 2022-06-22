/**
 * Created by marathoner on 2022/06/22
 */
class Calc {
}

val trim = """[^.\d-+*/]""".toRegex()
val groupMD = """((?:\+|\+-)?[.\d]+)([*/])((?:\+|\+-|)[.\d]+)""".toRegex()

// 공백 제거
fun trim(v: String): String = v.replace(trim, "")
// - 를 +- 로 변경
fun repMtoPM(v: String): String = v.replace("-", "+-")

fun foldGroup(v: String): Double = groupMD.findAll(v).fold(0.0) { acc, curr ->
    val (_, left, op, right) = curr.groupValues
    val leftValue = left.replace("+", "").toDouble()
    val rightValue = right.replace("+", "").toDouble()
    val result = when (op) {
        "*" -> leftValue * rightValue
        "/" -> leftValue / rightValue
        else -> throw Throwable("invalid operator &op")
    }

    acc + result
}
