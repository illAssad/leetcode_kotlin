import java.util.*

class Solution247 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = HashMap<Int, Int>()
        for (num in nums) {
            result[num] = result.getOrDefault(num, 0) + 1
        }

        val maxHeap = PriorityQueue<Map.Entry<Int, Int>>(compareBy {-it.value})
        result.forEach { row ->
            maxHeap.offer(row)
        }

        val output = IntArray(k) {0}
        for (i in output.indices) {
            output[i] = maxHeap.poll().key
        }
        return output
    }
}

fun main() {
    println(
        Solution247().topKFrequent(
            intArrayOf(
                1, 2, 3, 44, 4, 4, 5, 6, 7, 7, 7, 8, 9, 10
            ), 2
        ).contentToString()
    )
}