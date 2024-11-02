import kotlin.math.min


class Solution1091 {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) return -1

        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(1, 1),
            intArrayOf(-1, -1),
            intArrayOf(-1, 1),
            intArrayOf(1, -1)
        )
        val output = -1
        val dq = ArrayDeque<Pair<Int, Int>>()
        val seen = mutableSetOf<Pair<Int, Int>>()

        val start = Pair(0, 0)
        dq.add(start)
        seen.add(start)

        var depth = 1
        val lastC = grid[0].size - 1
        val lastR = grid.size - 1
        while (dq.isNotEmpty()) {
            for (i in 1..dq.size) {
                val current = dq.removeFirst()
                if ((current.first == lastR) && (current.second == lastC)) return depth

                for ((dr, dc) in directions) {
                    val nr = current.first + dr
                    val nc = current.second + dc
                    val next = Pair(nr, nc)
                    if (!seen.contains(next) && (min(
                            nr, nc
                        ) >= 0) && (nr < grid.size) && (nc < grid[0].size) && (grid[nr][nc] == 0)
                    ) {
                        dq.add(next)
                        seen.add(next)
                    }
                }
            }
            depth += 1
        }
        return output
    }
}

fun main() {
    val t = Solution1091()
    val grid = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )

    val grid2 = arrayOf(
        intArrayOf(0, 1, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 1),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )
    println(t.shortestPathBinaryMatrix(grid2))
}