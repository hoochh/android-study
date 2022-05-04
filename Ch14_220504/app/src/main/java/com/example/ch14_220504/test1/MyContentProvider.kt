package com.example.ch14_220504.test1

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri

class MyContentProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0 // delete, update의 경우 int값을 리턴함(현재는 0)
    }

    override fun getType(uri: Uri): String? {
        return null // 리턴형이 String?이므로 null 리턴 가능
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val cursor=MatrixCursor(arrayOf("data"))
        cursor.addRow(arrayOf("hello"))
        cursor.addRow(arrayOf("world"))
        return cursor
        // projection : 필드명, selection, selectionArgs, sortOrder : 조건 -> Cursor 형으로 반환
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 0
    }
}