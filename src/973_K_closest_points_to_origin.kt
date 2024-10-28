import java.util.PriorityQueue
import kotlin.math.pow
import kotlin.math.sqrt

class Solution973 {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<IntArray>(compareBy { -sqrt(it[0].toDouble().pow(2)+ it[1].toDouble().pow(2)) })
        points.forEach {
            pq.add(it)
            if (pq.size > k) pq.poll()
        }

        return pq.toTypedArray()
    }
}

fun main () {
    val t = Solution973()
    val input1 = arrayOf(intArrayOf(1,3), intArrayOf(-2,2))

    println(t.kClosest(input1, 1).contentToString())

}