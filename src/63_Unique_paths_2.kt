class Solution63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid[0][0] == 1) return 0
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        if (m==1 || n == 1) {
            val obsFound = obstacleGrid.flatMap { it.asIterable() }.contains(1)
            return if (obsFound) 0 else 1
        }
        // Initialize first row
        var row = Array(n) { 0 }
        // Fill first row until we hit an obstacle
        for (i in 0..<n) {
            if (obstacleGrid[0][i] == 1) break
            row[i] = 1
        }

        for (j in 1..<m) {
            row.forEachIndexed { index, _ ->
                if (obstacleGrid[j][index] == 1) {
                    row[index] = 0
                    return@forEachIndexed
                }
                val left =
                    if (index < 1 || obstacleGrid[j][index-1] == 1) 0 else row[index - 1]
                row[index] += left
            }

        }
        return row.last()
    }
}




fun main() {


    var input1 = arrayOf(
        intArrayOf(0, 0,0), intArrayOf(0, 1,0), intArrayOf(0,0,0)
    )
    println(Solution63().uniquePathsWithObstacles(input1))


}