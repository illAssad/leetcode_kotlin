import kotlin.math.max

class mock_interview_1 {

    fun maxAfterKMoves(nums: IntArray, k: Int): Int {
        if (nums.isEmpty() || ((nums.size == 1) && (k % 2 == 1))) return -1
        if (k > nums.size) return nums.max()
        if (k == 1) return nums[1]

        var maxSoFar = nums[0]
        if (k < nums.size) {
            var n = 1
            while (n < k - 1) {
                maxSoFar = max(maxSoFar, nums[n])
                n++
            }
            return max(maxSoFar, nums[k])
        } else {
            var n = 1
            while (n < k - 1) {
                maxSoFar = max(maxSoFar, nums[n])
                n++
            }
            return maxSoFar
        }
    }
}


fun main() {
    val t = mock_interview_1()
//   [91,98,17,79,15]   k = 2
    val input = intArrayOf(91, 98, 17, 79, 15)
    val input2 = intArrayOf(0,1,2)
//    [5,2,2,4,0,6], k = 4
//    Output: 5


    println(t.maxAfterKMoves(input, 2))
    println(t.maxAfterKMoves(input2, 3))


}