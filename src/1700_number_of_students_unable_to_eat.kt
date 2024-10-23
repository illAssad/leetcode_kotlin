import java.util.*

class Solution1700 {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val q = LinkedList<Int>(students.toList())
        var i = 0
        var want0 = students.count { it == 0 }
        var want1 = students.count { it == 1 }
        while (i < sandwiches.size) { // some condition here -> still need to
        // detect when we've gone through all the students
            val sando = sandwiches[i]
            if ((sando == 0 && want0 == 0) || (sando == 1 && want1 == 0)) return q.size
            val student = q.pop()
            if (sando == student) {
                if (sando == 0) want0-- else want1--
                i++
                continue
            }
            q.addLast(student)
        }
        return 0
    }
}