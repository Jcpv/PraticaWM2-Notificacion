package com.jc.praticawm2_notificacion
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.util.TimeUtils
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment


class TimePickerFragment : DialogFragment() {
    private var listener: TimePickerDialog.OnTimeSetListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker
        val h = Calendar.getInstance()
        val hora = h.get(Calendar.HOUR_OF_DAY)
        val minuto = h.get(Calendar.MINUTE)
        val segundo = h.get(Calendar.SECOND)

        // Create a new instance of DatePickerDialog and return it
        return TimePickerDialog(activity!!, listener, hora, minuto, true)
    }

    companion object {
        fun newInstance(listener: TimePickerDialog.OnTimeSetListener): TimePickerFragment {
            val fragment = TimePickerFragment()
            fragment.listener = listener
            return fragment
        }
    }
}