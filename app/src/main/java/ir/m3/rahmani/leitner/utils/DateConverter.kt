package ir.m3.rahmani.leitner.utils

import androidx.room.TypeConverter
import java.util.Calendar

class DateConverter(){

  @TypeConverter fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

  @TypeConverter fun datestampToCalendar(value: Long): Calendar =
    Calendar.getInstance().apply { timeInMillis = value }
}