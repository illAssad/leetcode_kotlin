class Solution131 {
    fun isPalindrome(candidate: String): Boolean {
        for (i in 0..<candidate.length.div(2)) {
            if (candidate[i] != candidate[candidate.length - i - 1]) return false
        }

        return true

    }

    fun partition(s: String): List<List<String>> {
        if (s.length == 1) return listOf(listOf(s))
        val output = mutableListOf<List<String>>()
        var current = mutableListOf<String>()

        fun dfs(i: Int) {
            if (i >= s.length) {
                output.add(current.toList())
                return
            }
            for (j in i until s.length) {
                val candidate = s.substring(i, j + 1)
                if (isPalindrome(candidate)) {
                    current.add(candidate)
                    dfs(j+1)
                    current.removeLast()
                }
            }

        }
        dfs(0)
        return output.toList()
    }
}


fun main() {
    val t = Solution131()

    val input1 = "fff"
    println(t.partition(input1))
//
    val input2 = "aab"
    println(t.partition(input2))

    val input3 = "a"
    println(t.partition(input3))
//
    val input4 = "aaa"
    println(t.partition(input4))
}