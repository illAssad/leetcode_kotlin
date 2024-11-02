class Solution207 {
    fun canFinish(
        numCourses: Int, prerequisites: Array<IntArray>
    ): Boolean {
        if (prerequisites.isEmpty()) return true
        val dependencyMap = HashMap<Int, MutableList<Int>>()
        for (prereq in prerequisites) {
            val course = prereq[0]
            val dependsOn = prereq[1]
            if (course == dependsOn) return false
            if (!dependencyMap.contains(dependsOn)) dependencyMap[dependsOn] =
                mutableListOf()
            if (dependencyMap.contains(course)) dependencyMap[course]?.add(
                dependsOn
            )
            else dependencyMap[course] = mutableListOf(dependsOn)
        }
        fun dfs(current: Int, seen: MutableSet<Int>): Boolean {
            if (seen.contains(current)) return false
            if (dependencyMap[current]?.isEmpty() == true) return true

            seen.add(current)
            dependencyMap[current]?.let {
                for (n in dependencyMap[current]!!) {
                    if (!dfs(n, seen)) return false
                }
            }
            seen.remove(current)
            dependencyMap[current]?.clear()
            return true
        }
        val set = mutableSetOf<Int>()
        for (option in 0..<numCourses) {
            if (!dfs(option, set)) return false
        }
        return true
    }
}

fun main() {
    val t = Solution207()
    val input = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 6),
        intArrayOf(1, 7),    // This creates a self-loop!
        intArrayOf(6, 4),
        intArrayOf(7, 0),
        intArrayOf(0, 5),
//        intArrayOf(15,1),
//        intArrayOf(17,4)
    )

    println(t.canFinish(8, input))
}