class Solution78 {
    var powerSet = mutableSetOf<MutableSet<Int>>()
    fun subsets(nums: IntArray): List<List<Int>> {
        var current = mutableSetOf<Int>()
        fun dfs(i: Int) {
            if (i >= nums.size) {
                powerSet.add(current.toMutableSet())
                return
            }
            current.add(nums[i])
            dfs(i + 1)

            current.remove(nums[i])
            dfs(i + 1)
        }
        dfs(0)
        return powerSet.toList().map { it.toList() }
    }
}

fun main () {
    println(Solution78().subsets(intArrayOf(1,2,3)).toString())
}