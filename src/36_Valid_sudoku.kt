class Solution36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in 0..8) {
            if (!checkSection(board, Pair(i, 0), Pair(i, 8))) return false
        }
        for (i in 0..8) {
            if (!checkSection(board, Pair(0, i), Pair(8, i))) return false
        }
        return checkSection(board, Pair(0,0), Pair(2,2)) && checkSection(
            board, Pair(0,3), Pair(2,5)
        ) && checkSection(board, Pair(0,6), Pair(2,8)) && checkSection(
            board, Pair(3,0), Pair(5,2)
        ) && checkSection(board, Pair(3,3), Pair(5,5)) && checkSection(
            board, Pair(3,6), Pair(5,8)
        ) && checkSection(board, Pair(6,0), Pair(8,2)) && checkSection(
            board, Pair(6,3), Pair(8,5)
        ) && checkSection(board, Pair(6,6), Pair(8,8))
    }

    fun checkSection(
        board: Array<CharArray>, start: Pair<Int, Int>, end: Pair<Int, Int>
    ): Boolean {
        val left = start.second
        val right = end.second
        val up = start.first
        val down = end.first
        val seen = mutableSetOf<Char>()

        for (i in up..down) {
            for (j in left..right) {
//                println(board[i][j])
                if (board[i][j] == '.') continue
                if (seen.contains(board[i][j])) return false
                seen.add(board[i][j])
            }
        }
        return true
    }
}

fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '3', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(Solution36().isValidSudoku(board ))
}