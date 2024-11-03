import kotlin.math.max

class Solution198 {
    fun rob(nums: IntArray): Int {
        if (nums.size < 3) return nums.max()
        if (nums.size == 3) return max(nums[0] + nums[2], nums[1])
        if (nums.size == 4) return maxOf(nums[0]+nums[3], nums[0]+ nums[2], nums[1]+nums[3])
        var last = intArrayOf(nums[0], nums[1], nums[0] + nums[2])
        var maximumSoFar = 0
        for (i in 3..<nums.size) {
            val option1 = nums[i] + last[1]
            val option2 = nums[i] + last[0]
            val current = max(option1, option2)
            last[0] = last[1]
            last[1] = last[2]
            last[2] = current
            maximumSoFar = max(maximumSoFar, current)
        }

        return maximumSoFar
    }
}

fun main() {
    println(Solution198().rob(intArrayOf(2,7,9,3,1)))
}