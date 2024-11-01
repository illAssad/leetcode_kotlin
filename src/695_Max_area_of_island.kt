import kotlin.math.max

class Solution695 {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        // m x n
        // 1 -> Land
        // 0 -> water
        var maxArea = 0
        val visited = mutableSetOf<Pair<Int, Int>>()
        val neighbors = ArrayDeque<Pair<Int, Int>>()
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(-1, 0),
            intArrayOf(0, -1)
        )
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val currentStartingPoint = Pair(i, j)
                if (visited.contains(currentStartingPoint) || grid[i][j] == 0) continue
                var area = 0
                neighbors.add(currentStartingPoint)
                visited.add(currentStartingPoint)
                while (neighbors.isNotEmpty()) { // dfs
                    val current = neighbors.removeFirst()
                    area++

                    for ((dx, dy) in directions) {
                        val nr = current.first + dx
                        val nc = current.second + dy
                        if ((nr >= 0) && (nc >= 0) && (nr < grid.size) && (nc < grid[0].size) && (grid[nr][nc] == 1) && !visited.contains(
                                Pair(nr, nc)
                            )
                        ) {
                            visited.add(Pair(nr, nc))
                            neighbors.add(Pair(nr, nc))
                        }
                    }
                }
                maxArea = max(maxArea, area)
            }
        }
        return maxArea
    }
}


fun main() {
    val t = Solution695()
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
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 1),
        intArrayOf(0, 0, 0, 1, 1)
    )
    println(t.maxAreaOfIsland(grid2))
}