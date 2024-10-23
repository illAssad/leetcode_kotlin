class Solution704 {
    fun search(nums: IntArray, target: Int): Int {
        var L = 0;
        var R = nums.size - 1;
        var mid = (L + R) / 2
        while (L <= R) {
            mid = (L + R).div(2)

            if (nums[mid] < target) { // then its in the right side
                L = mid + 1
            } else if (nums[mid] > target) {
                R = mid - 1
            } else {
                return mid
            }
        }
        return -1
    }
}

fun main() {
    println(Solution704().search(intArrayOf(1,2,3,4,5,6), 3))
}