import kotlin.math.absoluteValue
import kotlin.math.sign


class Solution875 {

    private val fastEnough = mutableSetOf<Int>()
    val tooSlow = mutableSetOf<Int>()

    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var L = 1
        var H = piles.max()
        var k: Int
        while (L <= H) {
            k = L + (H - L) / 2

            if (isEatingFastEnough(k, piles, h)) {
                if (k == 1) return k
                if (tooSlow.contains(k - 1)) return k
                else {
                    if (!isEatingFastEnough(k - 1, piles, h)) {
                        return k
                    }
                }
                H = k - 1
            } else {
                if (fastEnough.contains(k + 1)) return k + 1 else {
                    if (isEatingFastEnough(k + 1, piles, h)) return k + 1
                }
                L = k + 1
            }
        }

        return L
    }


    fun isEatingFastEnough(k: Int, piles: IntArray, h: Int): Boolean {
        var hoursEating = 0
        for (pile in piles) {
            hoursEating += pile.ceilDiv(k)
        }
        if (hoursEating <= h) {
            fastEnough.add(k)
            return true
        } else {
            tooSlow.add(k)
            return false
        }
    }
}

fun main() {
//    println(Solution875().minEatingSpeed(intArrayOf(3, 6, 7, 11), 8))
    println(Solution875().minEatingSpeed(intArrayOf(312884470), 968709470))
//    println(
//        Solution875().isEatingFastEnough(
//            4, intArrayOf(3, 6, 7, 11), 8
//        )
//    )
}

fun Int.ceilDiv(other: Int): Int {
    return this.floorDiv(other) + this.rem(other).sign.absoluteValue
}