class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val resultMap =
            mutableMapOf<MutableMap<Char, Int>, MutableList<String>>()

        for (str in strs) {
            val strMap = str.toMap()
            if (!resultMap.contains(strMap)) {
                resultMap[strMap] = mutableListOf(str)
            } else resultMap[strMap]?.add(str)
        }
        return resultMap.values.toList()
    }

}

fun String.toMap(): MutableMap<Char, Int> {
    val charCount = mutableMapOf<Char, Int>()
    for (i in this.indices) {
        val sChar = this[i]
        var count = charCount.getOrDefault(sChar, 0).plus(1)
        charCount[sChar] = count
    }
    return charCount
}


fun main() {
}
