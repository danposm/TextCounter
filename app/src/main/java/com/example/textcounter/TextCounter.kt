package com.example.textcounter

class TextCounter {
    fun countWords(input: String): Int {
        return input.split(Regex("\\s+|,|\\.")).count { it.isNotEmpty() }
    }

    fun countCharacters(input: String): Int {
        return input.length
    }
}
