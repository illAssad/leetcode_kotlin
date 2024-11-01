import kotlin.math.min

class Solution200 {
    // m x n grid
    // 1 -> land
    // 0 -> water
    // return # of islands
    private val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(0, -1)
    )

    fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val visited = mutableSetOf<Pair<Int, Int>>()
        var count = 0
        var stack = mutableListOf<Pair<Int, Int>>() //stack of coordinates
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (visited.contains(
                        Pair(
                            i, j
                        )
                    ) || grid[i][j] == '0'
                ) continue
                var current = Pair(i, j)
                stack.add(current)
                visited.add(current)
                while (stack.isNotEmpty()) {
                    current = stack.removeLast()
                    println("current: $current")
                    visited.add(current)
                    for (direction in directions) {
                        val nr = current.first + direction[0]
                        val nc = current.second + direction[1]
                        if (min(
                                nr, nc
                            ) >= 0 && (nr < m) && (nc < n) && (grid[nr][nc] != '0') && (!visited.contains(
                                Pair(nr, nc)
                            ))
                        ) {

                            println("Adding pair to stack: ${Pair(nr, nc)}")
                            stack.add(Pair(nr, nc))
                        }
                    }
                }
                count++
            }
        }
        return count
    }
}


fun main() {
    val t = Solution200()
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '1')
    )
    print(t.numIslands(grid))
}

