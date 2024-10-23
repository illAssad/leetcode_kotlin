import kotlin.math.min

class MinStack() {
    private val stack = arrayListOf<Pair<Int, Int>>()
    private var min: Int? = null
    fun push(`val`: Int) {
        min = min?.let { min(it, `val`) } ?: `val`
        stack.add(Pair(`val`, min!!))
    }

    fun pop() {
        stack.removeLast()
        min = getMin()
    }

    fun top(): Int {
        return stack.last().first
    }

    fun getMin(): Int {
        return stack.last().second
    }
}

fun main() {
    var obj = MinStack()
    obj.push(5)
    obj.push(-1)
    obj.push(5)
    obj.push(4)
    obj.push(8)
    obj.pop()
    var param_3 = obj.top()
    var param_4 = obj.getMin()

    println(param_3)
    println(param_4)
}