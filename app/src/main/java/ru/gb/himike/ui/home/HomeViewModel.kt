package ru.gb.himike.ui.home

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class HomeViewModel : ViewModel() {
    private val _countdownString = MutableLiveData<String>()
    val countdownString = _countdownString

    init {
        countdownStart()
    }

    private fun countdownStart() {

        val endDate = Calendar.getInstance()
        endDate.add(Calendar.DATE, 5)

        object : CountDownTimer(endDate.time.time - Calendar.getInstance().time.time, 2000) {

            override fun onTick(millisUntilFinished: Long) {
                var millisLeft = millisUntilFinished
                val secondsInMilli = 1000L
                val minutesInMilli = secondsInMilli * 60
                val hoursInMilli = minutesInMilli * 60
                val daysInMilli = hoursInMilli * 24

                val daysLeft = millisUntilFinished / daysInMilli
                millisLeft %= daysInMilli
                val hoursLeft = millisLeft / hoursInMilli
                millisLeft %= hoursInMilli
                val minutesLeft = millisLeft / minutesInMilli
                millisLeft %= minutesInMilli
                //${String.format("%.2d", hoursLeft)}
                _countdownString.postValue("${daysLeft}:${hoursLeft}:${minutesLeft}")
            }

            override fun onFinish() {
                _countdownString.postValue("Time Is Over!!!")
            }
        }.start()
    }
}