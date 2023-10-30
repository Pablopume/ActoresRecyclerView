package com.example.actoresrecyclerview.utils

import android.content.Context

class StringProvider(private val context: Context) {
    companion object {
        fun instance(context: Context): StringProvider = StringProvider(context)
    }

    fun getString(resourceId: Int): String {
        return context.getString(resourceId)
    }
}