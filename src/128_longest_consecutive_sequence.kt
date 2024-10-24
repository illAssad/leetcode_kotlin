import kotlin.math.max

class Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        var longest = 0
        val set = mutableSetOf<Int>(*nums.toTypedArray())

        for (num in nums) {
            if (set.contains(num - 1)) continue
            var currentLength = 0
            var currentNumber = num
            do {
                currentLength++
                currentNumber++

            } while (set.contains(currentNumber))
            longest = max(longest, currentLength)
        }

        println(longest)

        return longest
    }
}

fun main() {

    println(
        Solution128().longestConsecutive(
            intArrayOf(
                100, 4, 200, 1, 3, 2
            )
        )
    )
}