class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indexMap = HashMap<Int, Int>()

        for (i in nums.indices) {
            if (indexMap.contains(target - nums[i])) return intArrayOf(i, indexMap[target - nums[i]]!!)
            indexMap.put(nums[i], i)
        }


        return intArrayOf()
    }
}