/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution278 {
    fun isBadVersion(n: Int): Boolean {
        return n == 4
    }
    fun isFirstBadVersion(n: Int): Boolean {
        return (n == 1 && isBadVersion(n)) || (isBadVersion(n) && !isBadVersion(n-1))
    }
    fun firstBadVersion(n: Int) : Int {
        var L = 1
        var H = n
        var mid : Int
        if (isBadVersion(1)) return 1
        if (isFirstBadVersion(H)) return H
        while (L <= H) {
            mid = (L.div(2)+H.div(2))
            if (L%2==1&&H%2==1) mid++
            if (isBadVersion(mid)) {
                if (isFirstBadVersion(mid)) return mid
                H = mid - 1
            } else {
                L = mid + 1
            }
        }
        return H
    }
}

fun main () {
    println(Solution278().firstBadVersion(5))
}