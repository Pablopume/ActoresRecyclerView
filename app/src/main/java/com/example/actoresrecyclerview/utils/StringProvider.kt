package com.example.actoresapp.utils

import android.content.Context
import androidx.annotation.StringRes

class StringProvider(private val context: Context) {
    companion object {
        fun instance(context: Context): StringProvider = StringProvider(context)
    }

    fun getString(resourceId: Int): String {
        return context.getString(resourceId)
    }
}