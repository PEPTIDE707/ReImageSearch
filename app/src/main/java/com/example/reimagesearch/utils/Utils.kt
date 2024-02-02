package com.example.reimagesearch.utils

import android.content.Context
import android.util.Log
import com.example.reimagesearch.Constants.PREFS_NAME
import com.example.reimagesearch.Constants.PREF_KEY
import retrofit2.http.Query
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

//앱 전체에서 사용되는 유틸리티 함수들을 포함하는 객체
object Utils {

    //주어진 tiemstamp를 원하는 포맷으로 변환하여 반환합니다.
    fun getDateFromTimestampWithFormat(
        timestamp: String?,
        fromFormatformat: String?,
        toFormatformat: String?
    ): String {
        var date: Date? = null
        var res = ""
        try {
            val format = SimpleDateFormat(fromFormatformat)
            date = format.parse(timestamp)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        Log.d("date", "getDateFromTimestampWithFormat date >> $date")

        val df = SimpleDateFormat(toFormatformat)
        res = df.format(date)
        return res
    }

    //마지막 검색어를 Shared Preferences에 저장합니다.
    fun saveLastSearch(context: Context, query: String) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(PREF_KEY, query).apply()
    }

    //Shared Preferences에서 마지막 검색어를 가져옵니다.
    fun getLastSearch(context: Context): String? {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(PREF_KEY, null)
    }
}