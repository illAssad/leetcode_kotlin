class BrowserHistory(homepage: String) {
    class ListNode(
        var url : String,
        var back: ListNode? = null,
        var forward: ListNode? = null
    )
    private val start = ListNode(homepage)
    private var current : ListNode? = start
    fun visit(url: String) {
        val goTo = ListNode(url, current, null)
        current?.forward = goTo
        current = goTo
    }
    fun back(steps: Int): String {
        repeat(steps) {
            if (current?.back == null) {
                return current?.url!!
            }
            current = current?.back
        }
        return current?.url!!
    }

    fun forward(steps: Int): String {
        repeat(steps) {
            if (current?.forward == null) {
                return current?.url!!
            }
            current = current?.forward
        }
        return current?.url!!
    }

}


fun main(){
    val browserHistory = BrowserHistory("leetcode")

    browserHistory.visit("googe")
    browserHistory.visit("facebook")
    browserHistory.visit("youtube")
    browserHistory.back(1)
    browserHistory.back(1)
    browserHistory.forward(1)
    browserHistory.visit("linkedin")
    browserHistory.forward(2)
    browserHistory.back(2)
    browserHistory.back(7)
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */