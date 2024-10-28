import java.util.PriorityQueue

class KthLargest(private val k: Int, nums: IntArray) {

    val pq = PriorityQueue<Int>(k)
    init {
        nums.forEach {
            pq.add(it)
            if (pq.size > k) pq.poll()
        }
    }
    fun add(`val`: Int): Int {
        pq.add(`val`)
        if (pq.size > k) pq.poll()
        println(
            pq
        )
        return pq.peek()
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 *
 **/

fun main() {
    val test = KthLargest(4, intArrayOf(7, 7, 7, 7, 8, 3))

    println(test.add(4))
    println(test.add(2))
    println(test.add(10))
    println(test.add(9))
    println(test.add(9))
}