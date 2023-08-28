package me.imlc

class CharUtil {

    companion object {

        fun indexOfEndOfString(arr: CharArray): Int {
            for (i in 0..arr.size - 1) {
                if (arr[i] == ASCII_NULL) {
                    return i
                }
            }
            return arr.size
        }

        fun copyTo(from: CharArray, to: CharArray) {
            var index = indexOfEndOfString(to)
            for (i in 0..from.size - 1) {

                if (from[i] != ASCII_NULL) {
                    to[index++] = from[i]
                } else {
                    break
                }
            }
        }

        fun equals(a: CharArray, b: CharArray): Boolean {

            val lenOfA = indexOfEndOfString(a)
            var lenOfB = indexOfEndOfString(b)

            if (lenOfA != lenOfB) {
                return false
            }

            for (i in 0..lenOfA - 1) {
                if (a[i] != b[i]) {
                    return false
                }
            }

            return true;
        }


    }

}