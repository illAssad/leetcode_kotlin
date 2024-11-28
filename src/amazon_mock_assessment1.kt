import kotlin.math.pow

class AmazonSolution1 {
    fun countCharacters(words: Array<String>, chars: String): Int {
        var output = 0
        val charCounts = mutableMapOf<Char, Int>()
        for (each in chars) {
            charCounts[each] = charCounts.getOrDefault(each, 0) + 1
        }

        for (word in words) {
            val charCountsCopy = charCounts.toMutableMap()
            var isValid = true
            for (char in word) {
                if (charCountsCopy.contains(char)) {
                    charCountsCopy[char] = charCountsCopy[char]!! - 1
                    if (charCountsCopy[char]!! < 0) {
                        isValid = false
                        break
                    }
                } else {
                    isValid = false
                    break
                }
            }
            if (isValid) output += word.length
        }

        return output
    }

    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        var output = 0
        if (target == n || target == n*k) return 1
        if (target < n || target > n*k) return 0
        var config = mutableListOf<Int>()
        fun dfs(current: MutableList<Int>, curSum: Int) {
            if (current.size > n) return
            if (curSum > target) return
            if (curSum < target && current.size == n) return
            if (current.size == n && curSum == target) {
                output++
                return
            }
            for (i in 1..k) {
                current.add(i)
                dfs(current.toMutableList(), curSum + i)
                current.removeLast()
            }
        }
        dfs(config, 0)
        return output.mod((10.0.pow(9.0) + 7).toInt())
    }


// So this is some kind of backtracking solution, kind of like number of paths, or number of steps, etc.......
// There's also a memoization hidden in here somewhere.

// n dice -> all of these have to be between 1..k
// k faces -> These are possibilities for each dice
// target -> If we landed here this is a valid configuration
// if n > target -> 0 -> Can't do it -> Rolled value always larger than target
// if n == target -> 1 -> Have to Roll all ones to do it.
// if n * k < target -> 0 -> Can't do it -> Rolled value always smaller than target
// if n* k == target -> 1 -> Only 1 way to do it
// Otherwise, let's start counting
}

fun main() {
    val t = AmazonSolution1()

    println(t.numRollsToTarget(1,6,3))
}