import java.util.PriorityQueue
import kotlin.math.abs

class Solution1046 {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(compareBy { -it })
        stones.forEach { pq.add(it) }

        while (pq.size > 1) {
            val stone1 = pq.poll()
            val stone2 = pq.poll()

            val difference = abs(stone2 - stone1)
            if (difference > 0) pq.add(difference)
        }
        return if (pq.size == 0) 0 else pq.poll()
    }
}


fun main() {
    val t = Solution1046()

    val output1 = t.lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1))
}