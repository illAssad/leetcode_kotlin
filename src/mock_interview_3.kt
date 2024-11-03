// You are playing the Bulls and Cows game with your friend.

// You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

// The number of "bulls", which are digits in the guess that are in the correct position.
// The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.
// Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
// Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

// The hint should be formatted as "xAyB",
// where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

// Example 1:


////////
// cows is wrong position but in there somewhere
// bulls -> exact correct position
// Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
// output -> xAyB   x(number of bulls) y(numberOfCows)

//

class Mock3 {
    fun getHint(guess: String, target: String): String {
        var numberOfBulls = 0
        var numberOfCows = 0
        // iterate over guess and target 1 char at a time and if the match, increment bulls
        val map = mutableMapOf<String, Int>()
        val set = mutableSetOf<Int>()
        for (i in target.indices) {
            //case 1 -> Bull
            if (target[i] == guess[i]) {
                numberOfBulls++
                set.add(i)
                continue
            } else {
                map[target[i].toString()] =
                    map.getOrDefault(target[i].toString(), 0) + 1
            }
        }
        for (i in guess.withIndex()) {
            if ((map.getOrDefault(
                    i.value.toString(), 0
                ) > 0) && !set.contains(i.index)
            ) {
                numberOfCows++
                map[i.value.toString()] = map[i.value.toString()]!! - 1
            }
        }
        return "${numberOfBulls}A${numberOfCows}B"
    }
}

fun main () {
    println(Mock3().getHint("0111","1123" ))
}
// Input: secret = "1807", guess = "7810"
// Output: "1A3B"
// Explanation: Bulls are connected with a '|' and cows are underlined:
// "1807"
//   |
// "7810"
// Example 2:

// Input: secret = "1123", guess = "0111"
// Output: "1A1B"
// Explanation: Bulls are connected with a '|' and cows are underlined:
// "1123"        "1123"
//   |      or     |
// "0111"        "0111"
// Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.


// Constraints:

// 1 <= secret.length, guess.length <= 1000
// secret.length == guess.length
// secret and guess consist of digits only.
