package com.example.android_chat.data.model

import com.example.android_chat.data.db.entity.Chat
import com.example.android_chat.data.db.entity.UserInfo

data class ChatWithUserInfo(
    var mChat: Chat,
    var mUserInfo: UserInfo
)
