class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        var product = 1
        for (i in nums.withIndex()) {
            result[i.index] = product
            product *= i.value
        }

        product = 1
        for (i in nums.withIndex().reversed()) {
            result[i.index] *= product
            product *= i.value
        }

        return result

    }
}

fun main () {
    Solution238().productExceptSelf(intArrayOf(1,2,3,4))
}