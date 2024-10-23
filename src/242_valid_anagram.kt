import java.util.HashMap

class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val charCount = HashMap<Char, Int>()
        val disbalanced = mutableSetOf<Char>()
        for (i in s.indices) {
            val sChar = s[i]
            var count = charCount.getOrDefault(sChar, 0).plus(1)
            charCount[sChar] = count
            if (count != 0) disbalanced.add(sChar) else disbalanced.remove(
                sChar
            )
            val tChar = t[i]
            count = charCount.getOrDefault(tChar, 0).minus(1)
            charCount[tChar] = count
            if (count != 0) disbalanced.add(tChar) else disbalanced.remove(
                tChar
            )
        }

        return disbalanced.size == 0

    }
}

fun main() {
    println(Solution242().isAnagram("acc", "cab"))
}
