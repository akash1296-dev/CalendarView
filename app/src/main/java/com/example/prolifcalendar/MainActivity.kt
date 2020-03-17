package com.example.prolifcalendar

import EventDecorator
import android.app.usage.UsageEvents
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CalendarView
import android.widget.Toast
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import org.jetbrains.annotations.NotNull
import java.text.SimpleDateFormat

data class CalendarEvents(
        val label: String,
        val date: String,
        val kicks: String,
        val colorCode: String
)

class MainActivity : AppCompatActivity() {

    private val listCalendarEvents = ArrayList<CalendarEvents>()
    val sdf = SimpleDateFormat("yyyy-mm-dd")
    private lateinit var calendarView: MaterialCalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendarView = findViewById(R.id.cal_view)
        listCalendarEvents.add(CalendarEvents("02", "2020-03-02", "0", "#ffcc0000"))
        listCalendarEvents.add(CalendarEvents("02", "2020-03-03", "0", "#ff6969"))
        listCalendarEvents.add(CalendarEvents("02", "2020-03-04", "0", "#ffcc0000"))
        listCalendarEvents.add(CalendarEvents("02", "2020-03-05", "0", "#ffcc0000"))
        listCalendarEvents.add(CalendarEvents("02", "2020-03-06", "0", "#ffcc0000"))

        calendarView.state().edit()
            .setMinimumDate(CalendarDay.from(2020, 1, 1) )
            .setMaximumDate(CalendarDay.from(2020,5,25))
            .commit()

        for (i in listCalendarEvents) {
             val date = sdf.parse(i.date)
            val split =i.date.split("-")
            val year = split[0].toInt()
            val month = split[1].toInt()
            val day = split[2].toInt()
            val mydate=CalendarDay.from(year,  month, day) // year, month, date
            calendarView.addDecorators(EventDecorator(this, mydate, Color.parseColor(i.colorCode)))
//            val mydate = CalendarDay.from(year,month,day)
//            val eventDecorator = EventDecorator(calendarView, date, Color.parseColor(i.colorCode))
//            calendarView.addDecorator(eventDecorator)
        }

        calendarView.setOnDateChangedListener { view, day, boolean ->
            Toast.makeText(applicationContext,"Date is $day",Toast.LENGTH_SHORT).show();
            Log.d("MainAct", "Date is $day")
        }

    }
}
