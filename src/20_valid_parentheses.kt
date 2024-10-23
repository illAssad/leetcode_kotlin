class Solution20 {
    fun isValid(s: String): Boolean {
        val stack = arrayListOf<Char>()
        val closing = setOf<Char>(')', '}', ']')
        if (s.length % 2 != 0) return false
        for (b in s) {
            if (closing.contains(b) && stack.isNotEmpty()) {
                when (true) {
                    (b == ')' && stack.removeLast()=='(') -> continue
                    (b == ']' && stack.removeLast()=='[') -> continue
                    (b == '}' && stack.removeLast()=='{') -> continue
                    else -> return false
                }
            } else {
                stack.add(b)
            }
        }
        return stack.isEmpty()
    }
}



fun main() {
    print(Solution20().isValid("()[]{}"))

}