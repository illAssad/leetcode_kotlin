import java.util.PriorityQueue

class Solution215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>(compareBy { it })

        nums.forEach {
            pq.add(it)
            if (pq.size > k) pq.poll()
        }

        return pq.peek()
    }
}