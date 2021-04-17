package com.jc.praticawm2_notificacion

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.editFecha).setOnClickListener(){
            showDatePickerDialog()
        }

        findViewById<EditText>(R.id.editHora).setOnClickListener(){
            showTimePickerDialog()
        }

        findViewById<Button>(R.id.btnGuardar).setOnClickListener(){
            Toast.makeText(this,"Notificación Guardada", Toast.LENGTH_LONG)
            Log.i("[GUARDADO]", "Mensaje guardado")
        }




        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            //.setSmallIcon(R.drawable.notification_icon)
            .setContentTitle("Notify Pepe")
            .setContentText("Esta es mi NOtificación, favor de mirar")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


    }

    private fun showDatePickerDialog() {
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->
            val selectedDate = day.dosDigitos() + "/" + (month + 1).dosDigitos() + "/" + year.dosDigitos()
            findViewById<EditText>(R.id.editFecha).setText(selectedDate.toString())
        })
        newFragment.show(supportFragmentManager, "datePicker")
    }

    private fun showTimePickerDialog() {
        val newFragment = TimePickerFragment.newInstance(TimePickerDialog.OnTimeSetListener { _, hora, minuto ->
            val horaMin = hora.dosDigitos() + ":" + minuto.dosDigitos()
            findViewById<EditText>(R.id.editHora).setText(horaMin.toString())
        })
        newFragment.show(supportFragmentManager, "timePicker")
    }

    //extension function para adjuntar el método twoDigits sobre la clase Int:
    fun Int.dosDigitos() =
        if (this <= 9) "0$this" else this.toString()

/*
    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }*/

}