class Solution150 {
    fun evalRPN(tokens: Array<String>): Int {
        val operators = setOf("+", "-", "/", "*")
        val stack = ArrayDeque<String>()

        for (token in tokens) {
            if (operators.contains(token)) {
                val first = stack.removeLast()
                val second = stack.removeLast()
                val result = when (token) {
                    "+" -> first.toInt() + second.toInt()
                    "-" -> second.toInt() - first.toInt()
                    "*" -> first.toInt() * second.toInt()
                    "/" -> second.toInt().div(first.toInt())
                    else -> {
                        throw Error("Not valid operator")
                    }
                }
                stack.add(result.toString())
            } else {
                stack.add(token)
            }


        }
        return stack.removeLast().toInt()
    }
}

fun main() {
    println(Solution150().evalRPN(arrayOf("4","13","5","/","+")))
}