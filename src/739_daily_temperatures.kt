class Solution739 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        // 1. init int Array output
        // 2. Initialize a stack which will hold pairs (the temp, and it's index)
        // 3. Put the very first element in the stack <- maybe not come back to this
        // 4. Start iterating over each element -> We want the current index and value
            // 4.1 For each element assign it to current
            // 4.2 While current is greater than top of stack's temp do this
                // 4.2.1 Pop the stack
                // 4.2.2 At popped el's index, set output to currentIndex - popped el's index
        // everything is init to 0 so that takes care of the edge cases. return output
        val output = IntArray(temperatures.size) { 0 }
        val stack = ArrayDeque<Pair<Int, Int>>()

        for (current in temperatures.withIndex()) {
            while (stack.isNotEmpty() && current.value > stack.last().first) {
                val colder = stack.removeLast()
                output[colder.second] = current.index - colder.second
            }
            stack.add(Pair(current.value, current.index))
        }
        return output
    }
}
fun main() {
    val t = Solution739()

    println(t.dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)).contentToString())
}
