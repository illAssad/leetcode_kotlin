import kotlin.math.min

/*
# Rotting Oranges

You are given an `m x n` grid where each cell can have one of three values:

- `0` representing an empty cell,
- `1` representing a fresh orange, or
- `2` representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return `-1`.

## Examples

### Example 1:

**Input:**

grid = [
    [2,1,1],
    [1,1,0],
    [0,1,1]
]

**Output:** 4

### Example 2:

**Input:**

grid = [
    [2,1,1],
    [0,1,1],
    [1,0,1]
]

**Output:** -1

**Explanation:** The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

### Example 3:

**Input:**

grid = [[0,2]]

**Output:** 0

**Explanation:** Since there are already no fresh oranges at minute 0, the answer is just 0.

## Constraints:

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 10`
- `grid[i][j]` is `0`, `1`, or `2`.
*/

class SolutionAmazonTechScreen {
    fun countMinutes(grid: List<Array<Int>>): Int {
        val directions =
            listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))
        var timer = 0
        val m = grid.size
        val n = grid[0].size

        val q = ArrayDeque<Pair<Int, Int>>()// O(m x n)
        val freshOranges = mutableSetOf<Pair<Int, Int>>()

        // O(m x n)
        // constant space
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val current = grid[i][j]
                if (current == 2) {
                    q.add(Pair(i, j))
                } else if (current == 1) freshOranges.add(Pair(i, j))
            }
        }

        // O( V + E )
        while (q.isNotEmpty()) {
            // some trickery here we want a nested loop to process everythiung in a layer
            val layerSize = q.size
            repeat(layerSize) {
                val current = q.removeFirst()
                val r = current.first
                val c = current.second

                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc

                    if (min(
                            nr, nc
                        ) >= 0 && r < m && nc < n && grid[nr][nc] == 1
                    ) { // careful here, think about seen cases later
                        grid[nr][nc] = 2
                        q.addLast(Pair(nr, nc))
                        freshOranges.remove(Pair(nr, nc))
                        if (freshOranges.isEmpty()) return timer + 1
                    }
                }
            }
            timer++
        }
        return if (freshOranges.isEmpty()) timer else -1
    }
}


/*




Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,0]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:

Input: nums = [1], k = 1
Output: [1]



Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    1 <= k <= nums.length



*/

// PQ is of type Pair<Int, Int> which represents -> <Value , Index>
// Comparator would be () -> {-it.first}
// Given Array, and K
// Start by intiializing the window
// This will give you 1 item in your output array which is the max in the window so far.
// As part of this init operation create a maxHeap or priorityQueue s.t you can always see the max Elemenent at that point in time.

// Move window
// If element leaving is at top of PQ remove it from the PQ.
// Add the element coming in to the PQ.
// While PQ.peek() is not within the window, keep popping

// Time complexity.
// 1. Traverse everything O(n)
// 2. Insertion into PQ is log(n) operation you do this
// O (n log n)
// Space complexity
// 1. Heap is what takes up all the space. O(n)
