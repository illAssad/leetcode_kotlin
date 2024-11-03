class Solution62 {
    fun uniquePaths(m: Int, n: Int): Int {
        val matrix = Array(m) {IntArray(n) {1} }

        for (i in 1..<m) {
            for (j in 1..<n) {
                val left = if (i < 1) 0 else matrix[i-1][j]
                val up = if (j < 1) 0 else matrix[i][j-1]
                matrix[i][j] = left+up
            }
        }
        return matrix[m-1][n-1]
    }
}

fun main() {
    println(Solution62().uniquePaths(3,7))
}