package com.example.android_chat.util

fun isEmailValid(email: CharSequence): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isTextValid(minLength: Int, text: String?): Boolean {
    if (text.isNullOrBlank() || text.length < minLength) {
        return false
    }
    return true
}

