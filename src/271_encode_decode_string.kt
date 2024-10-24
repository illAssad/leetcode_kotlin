class Solution271 {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    fun encode(strs: List<String>): String {
        var result: String = ""
        for (word in strs) {
            result += "${word.length}#${word}"
        }
        return result
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    fun decode(str: String): List<String> {
        var L = 0
        var R = 0
        var output = mutableListOf<String>()
        do {
            if (str[++R] == '#') {
                val length = str.substring(L..<R).toInt()
                output.addLast(str.substring(R + 1..R + length))
                L = R + length + 1
                R = L
            }
        } while (R<str.length && str[R] != '#')

        return output
    }
}


fun main() {
    val encoded = Solution271().encode(listOf("123", "abc", "", ""))
    println(Solution271().decode(encoded))
}