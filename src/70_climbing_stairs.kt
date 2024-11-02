class Solution70 {
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        var prev = arrayOf(1,2)
        for (i in 3..<n) {
            var current = prev.sum()
            prev[0] = prev[1]
            prev[1] = current
        }
        return prev.sum()
    }
}

fun main() {

    println(Solution70().climbStairs(2))
    println(Solution70().climbStairs(3))
    println(Solution70().climbStairs(4))
    println(Solution70().climbStairs(5))
}
