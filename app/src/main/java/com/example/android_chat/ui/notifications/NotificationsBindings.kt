package com.example.android_chat.ui.notifications

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_chat.data.db.entity.UserInfo

@BindingAdapter("bind_notifications_list")
fun bindNotificationsList(listView: RecyclerView, items: List<UserInfo>?) {
    items?.let { (listView.adapter as NotificationsListAdapter).submitList(items) }
}
