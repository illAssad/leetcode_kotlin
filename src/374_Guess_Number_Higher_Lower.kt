/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution374 {

    fun guess(guess: Int): Int {
        if (guess > 1702766719) return -1
        if (guess < 1702766719) return 1
        return 0
    }
    fun guessNumber(n:Int):Int {
        var L = 1
        var H = n
        var mid: Int
        while (L <= H) {
            mid =  L.div(2) + H.div(2)
            if (L%2 == 1 && H%2==1) mid++
            val answer = guess(mid)
            when (answer) {
                -1 -> {
                    H = mid - 1
                }
                1 -> {
                    L = mid + 1
                }
                else -> return mid
            }
        }
        return -1
    }
}

fun main () {
    println(Solution374().guessNumber(2126753390))
}