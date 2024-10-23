class Solution217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>(*nums.toTypedArray())  // Spread the IntArray directly
        return (set.size != nums.size)
    }
}

fun main() {
    println(Solution217().containsDuplicate(intArrayOf(1,1,2,3,4)))
}