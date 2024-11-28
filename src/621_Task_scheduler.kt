import java.util.PriorityQueue

class Solution621 {
    fun leastInterval(tasks: CharArray, n: Int): Int {

        // Get the frequency of each task.
        // populate the pq
        // if q has elements, and it is that interval, then take the queue item for processing.
        // put it back in the PQ with one less occurrence.
        // otherwise, process the element from the PQ
        // this means putting it to end of queue with 1 less occurrence
        val occurrences = mutableMapOf<Char, Int>()
        var interval = 0
        var q = ArrayDeque<Pair<Int, Int>>()
        var priorityQueue = PriorityQueue<Int>(compareBy { -it })
        for (task in tasks) {
            occurrences[task] = occurrences.getOrDefault(task, 0) + 1
        }
        for (item in occurrences) {
            priorityQueue.add(item.value)
        }

        while (priorityQueue.isNotEmpty() || q.isNotEmpty()) {
            interval++
            if (q.isNotEmpty() && q.first().second <= interval) { // process queue
                val processing = q.removeFirst()
                priorityQueue.add(processing.first)
            }
            if (priorityQueue.isNotEmpty()) {
                val processing = priorityQueue.poll()
                if (processing > 1) q.add(
                    Pair(
                        processing - 1, interval + n + 1
                    )
                )
            }
        }
        return interval
    }
}

fun main() {
    val t = Solution621()
    println(t.leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 3))
}