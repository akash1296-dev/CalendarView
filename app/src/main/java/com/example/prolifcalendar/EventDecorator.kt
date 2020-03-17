import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.prolifcalendar.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

/*
package com.example.prolifcalendar

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.util.*


class EventDecorator(view: MaterialCalendarView, date: Date, color: Int) : DayViewDecorator {

    var drawable: Drawable? = null
    lateinit var day: CalendarDay

    init {
        day = CalendarDay.from(date)
        drawable = createTintedDrawable(view.context, color)
    }

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        if (day?.equals(day)!!) {
            return true;
        }
        return false;
    }


    override fun decorate(view: DayViewFacade?) {
        drawable?.let { view?.setSelectionDrawable(it) }
    }

    private fun createTintedDrawable(context: Context, color: Int): Drawable? {
        return applyTint(createBaseDrawable(context), color)
    }

    private fun applyTint(drawable: Drawable?, color: Int): Drawable? {
        val wrappedDrawable = DrawableCompat.wrap(drawable!!)
        DrawableCompat.setTint(wrappedDrawable, color)
        return wrappedDrawable
    }

    private fun createBaseDrawable(context: Context): Drawable? {
        return ContextCompat.getDrawable(context, R.drawable.arrow_down_float)
    }
}*/

class EventDecorator(context: Activity?, currentDay: CalendarDay, color: Int) : DayViewDecorator {
    private var drawable: Drawable? = null
    var myDay = currentDay
    override fun shouldDecorate(day: CalendarDay): Boolean {
        return day == myDay
    }

    override fun decorate(view: DayViewFacade) {
        view.setSelectionDrawable(drawable!!)
    }

    init {
        // You can set background for Decorator via drawable here
        drawable = context?.applicationContext?.let { createTintedDrawable(it, color) }
    }

    private fun createTintedDrawable(context: Context, color: Int): Drawable? {
        return applyTint(createBaseDrawable(context), color)
    }

    private fun applyTint(drawable: Drawable?, color: Int): Drawable? {
        val wrappedDrawable = DrawableCompat.wrap(drawable!!)
        DrawableCompat.setTint(wrappedDrawable, color)
        return wrappedDrawable
    }

    private fun createBaseDrawable(context: Context): Drawable? {
        return ContextCompat.getDrawable(context, R.drawable.day_cal)
    }
}
