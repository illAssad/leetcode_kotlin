import kotlin.math.max
import kotlin.math.min

class Solution11 {
    fun maxArea(height: IntArray): Int {

        // constraints
        // n -> height.size
        // 2<=n<=10^5
        // height[i] > 0

        // can we do brute force? yes
        // init a max area of 0
        // check every possible combination's area,
        // global_max = max(cur_max, cur_area)
//        var globalMax = 0
//        for (i in 0..<height.size - 1) for (j in i + 1..<height.size) {
//            val currentArea = (j - i) * min(height[i], height[j])
//            globalMax = max(globalMax, currentArea)
//
//        }
//        return globalMax

        // Brute force? no
        // start with a pointer at either end -> left , right
        // computer the area for this combo -> compare with global_max and set
        // then we move in ward the smaller of the two height[left] / [right]
        // we can do this because we know we are losing a 1 width in either case
        // which means the loss in area is 100% made up of height difference

        var l = 0;
        var r = height.size - 1
        var maxArea = 0

        while (l<r) {
            val currentArea = (r-l) * min(height[l], height[r])
            maxArea = max(currentArea, maxArea)

            if (height[l]>=height[r]) r--
            else l++
        }

        return maxArea
    }
}

