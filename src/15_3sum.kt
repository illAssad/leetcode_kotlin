import kotlin.math.sign

class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val output = mutableSetOf<List<Int>>()
        for (i in 0..<nums.size - 2) {
            for (j in i + 1..<nums.size - 1) {
                for (k in j + 1..<nums.size) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        output.add(
                            listOf(
                                nums[i], nums[j], nums[k]
                            ).sorted()
                        )
                    }
                }

            }
        }
        return output.toList()

    }

    fun threeSumOptimized(nums: IntArray): List<List<Int>> {
        val sorted = nums.sorted()
        val out = HashSet<List<Int>>()

        for (i in sorted.withIndex()) {
            if (i.value > 0) break
            if (i.index > 0 && i.value == sorted[i.index - 1]) continue
            var low = i.index+1;
            var high = nums.size - 1

            while (low < high) {
                val sum = i.value + sorted[low] + sorted[high]
                if (sum > 0) high--
                else if (sum < 0) low++
                else {
                    out.add(listOf(i.value, sorted[low], sorted[high]))
                    low++
                    high--
                }
            }
        }
        return out.toList()
    }

}

fun main() {
    Solution15().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
}