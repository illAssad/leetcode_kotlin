class Solution74 {
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

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix[0].size
        var mL = 0;
        var mR = matrix.size - 1;
        var mMid: Int
        while (mL <= mR) {
            mMid = (mL + mR).div(2)

            if ((matrix[mMid][0] <= target && target <= matrix[mMid][n-1])) {
                return (search(matrix[mMid], target) != -1)
            }
            if (matrix[mMid][0] < target) { // then its in the right side
                mL = mMid + 1
            } else if (matrix[mMid][0] > target) {
                mR = mMid - 1
            } else {
                return true
            }
        }
        return false
    }
}

fun main() {
    val input1 = arrayOf(
        intArrayOf(1, 3),
    )
    println(Solution74().searchMatrix(input1, 3))
}