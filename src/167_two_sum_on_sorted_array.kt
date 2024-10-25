class Solution167() {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        var L = 0
        var R = numbers.size - 1

        while (L < R) {
            var count = 1
            var isBreak = false
            for (i in L..<R) {
                val sum = numbers[L] + numbers[L + count]
                if (sum == target) return intArrayOf(L + 1, L + count + 1)
                if (sum > target) {
                    L++
                    R--
                    isBreak = true
                    break
                }
                count++
            }
            if (!isBreak) L++
        }

        return result
    }
}


fun main() {
    var s = Solution167()
    var input = intArrayOf(1, 2, 3, 4, 4, 9, 56, 90)
    var target = 8
    println(s.twoSum(input, target).contentToString())

}