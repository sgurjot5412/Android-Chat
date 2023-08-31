package com.example.android_chat.data.db.entity

import com.google.firebase.database.PropertyName


data class User(
    @get:PropertyName("info") @set:PropertyName("info") var info: UserInfo = UserInfo(),
    @get:PropertyName("friends") @set:PropertyName("friends") var friends: HashMap<String, UserFriend> = HashMap(),
    @get:PropertyName("notifications") @set:PropertyName("notifications") var notifications: HashMap<String, UserNotification> = HashMap(),
    @get:PropertyName("sentRequests") @set:PropertyName("sentRequests") var sentRequests: HashMap<String, UserRequest> = HashMap()
)
{
    companion object {
        // Conversion function from User1 to User
        fun fromUser1(user1: User1): User {
            return User(
                info = user1.info,
                friends = hashMapOf("friend" to user1.friends),
                notifications = hashMapOf("notification" to user1.notifications),
                sentRequests = hashMapOf("request" to user1.sentRequests)
            )
        }
    }
}

data class User1(
    @get:PropertyName("info") @set:PropertyName("info") var info: UserInfo = UserInfo(),
    @get:PropertyName("friends") @set:PropertyName("friends") var friends: UserFriend = UserFriend(),
    @get:PropertyName("notifications") @set:PropertyName("notifications") var notifications: UserNotification = UserNotification(),
    @get:PropertyName("sentRequests") @set:PropertyName("sentRequests") var sentRequests: UserRequest = UserRequest()
)

data class UserFriend(
    @get:PropertyName("userID") @set:PropertyName("userID") var userID: String = ""
)

data class UserInfo(
    @get:PropertyName("id") @set:PropertyName("id") var id: String = "",
    @get:PropertyName("displayName") @set:PropertyName("displayName") var displayName: String = "",
    @get:PropertyName("status") @set:PropertyName("status") var status: String = "No status",
    @get:PropertyName("profileImageUrl") @set:PropertyName("profileImageUrl") var profileImageUrl: String = "",
    @get:PropertyName("online") @set:PropertyName("online") var online: Boolean = false
)

data class UserNotification(
    @get:PropertyName("userID") @set:PropertyName("userID") var userID: String = ""
)

data class UserRequest(
    @get:PropertyName("userID") @set:PropertyName("userID") var userID: String = ""
)

