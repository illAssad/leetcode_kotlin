class Solution1929 {
    fun getConcatenation(nums: IntArray): IntArray {
        val ans = IntArray(nums.size * 2)
        for (i in nums.indices) {
            ans[i] = nums[i]
            ans[i+nums.size] = nums[i]
        }
        return ans
    }
}


fun main() {
    print(Solution1929().getConcatenation(intArrayOf(0, 1, 2, 2, 4, 4)).contentToString() )
}