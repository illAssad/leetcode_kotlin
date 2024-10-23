class Solution27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in nums.indices) {
            if (nums[i] == `val`) continue
            nums[k] = nums[i]
            k++
        }
        return k
    }
}



fun main() {
    print(Solution27().removeElement(intArrayOf(0,1,2,2,4,4),2))

}