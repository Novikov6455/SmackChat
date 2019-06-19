package com.example.smack.Services

import android.support.test.espresso.idling.CountingIdlingResource

object IdlingResourceHelper {
    val countingIdlingResource = CountingIdlingResource("CountingIdlingResource")
}
