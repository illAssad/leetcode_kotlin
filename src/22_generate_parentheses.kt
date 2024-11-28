class Solution22 {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 0) return listOf()
        val output = mutableListOf<String>()
        val stack = ArrayDeque<Triple<String, Int, Int>>()
        // Second -> Left brackets remaining
        // Third -> Right brackets remaining
        stack.add(Triple("", 0, 0))
        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            if (current.second == n && current.third == n) {
                output.add(current.first)
                continue
            }
            if (current.second < n){
                stack.add(Triple(current.first + "(", current.second + 1, current.third))
            }
            if (current.third < current.second) {
                stack.add(Triple(current.first + ")", current.second, current.third + 1))
            }
        }
        return output
    }
}

fun main() {
    val t = Solution22()
    println(t.generateParenthesis(2))
}
