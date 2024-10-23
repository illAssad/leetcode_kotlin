class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        // point at the spot after
        if (nums.size <= 1) return nums.size
        var current = nums[0]
        var size = 1
        for (i in 1..<nums.size) {
            if (nums[i] == current) continue
            nums[size] = nums[i]
            size++
            current = nums[i]
        }
        return size
    }
}



fun main() {
    print(Solution26().removeDuplicates(intArrayOf(0,1,2,2,4,4)))

}