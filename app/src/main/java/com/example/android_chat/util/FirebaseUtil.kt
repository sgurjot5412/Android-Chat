package com.example.android_chat.util

import com.google.firebase.database.DataSnapshot

fun <T> wrapSnapshotToClass(className: Class<T>, snap: DataSnapshot): T? {
    return snap.getValue(className)
}

fun <T> wrapSnapshotToArrayList(className: Class<T>, snap: DataSnapshot): MutableList<T> {
    val arrayList: MutableList<T> = mutableListOf()
    for (child in snap.children) {
        child.getValue(className)?.let {
            println(it)
            arrayList.add(it)
        }
    }
    return arrayList
}

// Always returns the same combined id when comparing the two users id's
fun convertTwoUserIDs(userID1: String, userID2: String): String {
    return if (userID1 < userID2) {
        userID2 + userID1
    } else {
        userID1 + userID2
    }
}